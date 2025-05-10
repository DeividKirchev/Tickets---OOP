package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.EventList;
import bg.tu_varna.sit.b1.f23621684.data.reporters.EventDataReporter;
import bg.tu_varna.sit.b1.f23621684.exceptions.HallAlreadyBookedException;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.models.Event;
import bg.tu_varna.sit.b1.f23621684.parameters.DateParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.HallParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.StringParameter;

public class AddEventCommand extends MenuCommand {
    private final DateParameter date;
    private final HallParameter hall;
    private final StringParameter name;

    public AddEventCommand(Menu menu) {
        super("addevent", "add a new event on <date> with <name> in hall <hall>", menu);

        DateParameter date = new DateParameter("date", false);
        HallParameter hall = new HallParameter("hall", false);
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

        EventList eventList = EventList.getInstance();
        eventList.add(new Event(hall, name, date));

        log("Successfully added event\n");
    }
}
