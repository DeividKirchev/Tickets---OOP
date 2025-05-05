package bg.tu_varna.sit.b1.f23621684.menu.commands;

import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommand;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommandParameter;
import bg.tu_varna.sit.b1.f23621684.validators.DateValidator;
import bg.tu_varna.sit.b1.f23621684.validators.IntegerValidator;
import bg.tu_varna.sit.b1.f23621684.validators.StringValidator;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.ValidatableParameter;

import java.util.List;

public class AddEventCommand extends MenuCommand {
    private ValidatableParameter date;
    private ValidatableParameter hall;
    private ValidatableParameter name;

    public AddEventCommand(Logger logger) {
        super("addevent", "add a new event on <date> with <name> in hall <hall>", logger);

        ValidatableParameter date = new MenuCommandParameter("date", false);
        date.addValidator(new DateValidator());

        ValidatableParameter hall = new MenuCommandParameter("hall", false);
        hall.addValidator(new IntegerValidator());

        ValidatableParameter name = new MenuCommandParameter("name", false);
        name.addValidator(new StringValidator());

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
        var strHall = data.get(this.hall);
        var hallId = Integer.parseInt(strHall);

        var name = data.get(this.name);

        log("Successfully added event");
    }
}
