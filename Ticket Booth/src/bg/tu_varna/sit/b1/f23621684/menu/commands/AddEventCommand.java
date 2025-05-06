package bg.tu_varna.sit.b1.f23621684.menu.commands;

import bg.tu_varna.sit.b1.f23621684.data.EventList;
import bg.tu_varna.sit.b1.f23621684.data.reporters.HallDataReporter;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommand;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommandParameter;
import bg.tu_varna.sit.b1.f23621684.models.Date;
import bg.tu_varna.sit.b1.f23621684.models.Event;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.ValidatableParameter;
import bg.tu_varna.sit.b1.f23621684.validators.input.DateInputValidator;
import bg.tu_varna.sit.b1.f23621684.validators.input.HallIdInputValidator;
import bg.tu_varna.sit.b1.f23621684.validators.input.StringInputValidator;

import java.util.List;

public class AddEventCommand extends MenuCommand {
    private ValidatableParameter date;
    private ValidatableParameter hall;
    private ValidatableParameter name;

    public AddEventCommand(Logger logger) {
        super("addevent", "add a new event on <date> with <name> in hall <hall>", logger);

        ValidatableParameter date = new MenuCommandParameter("date", false);
        date.addValidator(new DateInputValidator());

        ValidatableParameter hall = new MenuCommandParameter("hall", false);
        hall.addValidator(new HallIdInputValidator());

        ValidatableParameter name = new MenuCommandParameter("name", false);
        name.addValidator(new StringInputValidator());

        this.addCommandParameter(date).addCommandParameter(hall).addCommandParameter(name);

        this.date = date;
        this.hall = hall;
        this.name = name;
    }

    @Override
    public void execute(List<String> input) {
        var data = super.getMappedParams(input);
        if (data == null) return;

        var strDate = data.get(this.date);
        var date = new Date();
        date.fromString(strDate);

        var strHall = data.get(this.hall);
        var hallId = Integer.parseInt(strHall);
        var hall = HallDataReporter.getById(hallId);

        var name = data.get(this.name);

        EventList eventList = EventList.getInstance();
        eventList.add(new Event(hall, name, date));

        log("Successfully added event");
    }
}
