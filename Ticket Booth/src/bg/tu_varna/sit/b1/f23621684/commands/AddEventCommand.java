package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.EventList;
import bg.tu_varna.sit.b1.f23621684.exceptions.HallAlreadyBookedException;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.models.Event;
import bg.tu_varna.sit.b1.f23621684.parameters.DateParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.HallIdParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.StringParameter;
import bg.tu_varna.sit.b1.f23621684.validators.AvailableHallValidator;

public class AddEventCommand extends MenuCommand {
    private final DateParameter date;
    private final HallIdParameter hall;
    private final StringParameter name;

    public AddEventCommand(Menu menu) {
        super("addevent", "add a new event on <date> with <name> in hall <hall>", menu);

        DateParameter date = new DateParameter("date", false);
        HallIdParameter hall = new HallIdParameter("hall", false);
        StringParameter name = new StringParameter("name", false);

        this.addCommandParameter(date).addCommandParameter(hall).addCommandParameter(name);

        this.date = date;
        this.hall = hall;
        this.name = name;
    }
    @Override
    public void handleExecute() {

        var date = this.date.getValue();

        var hall = this.hall.getValue();

        var name = this.name.getValue();

        var validator = new AvailableHallValidator(hall, date);
        if (!validator.validate())
            throw new HallAlreadyBookedException("Hall is already booked for the date");

        EventList eventList = EventList.getInstance();
        eventList.add(new Event(hall, name, date));

        log("Successfully added event");
    }
}
