package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.reporters.EventDataReporter;
import bg.tu_varna.sit.b1.f23621684.data.reporters.TicketReporter;
import bg.tu_varna.sit.b1.f23621684.exceptions.EventNotFound;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.parameters.DateParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.StringParameter;

public class FreeSeatsCommand extends MenuCommand {
    private final DateParameter date;
    private final StringParameter name;

    public FreeSeatsCommand(Menu menu) {
        super("freeseats", "shows information about the free seats for event <name> on <date>", menu);

        DateParameter date = new DateParameter("date", false);
        StringParameter name = new StringParameter("name", false);

        this.addCommandParameter(date).addCommandParameter(name);

        this.date = date;
        this.name = name;
    }

    @Override
    public void handleExecute() {

        var date = this.date.getValue();

        var name = this.name.getValue();

        var event = EventDataReporter.getEvent(name, date);
        if (event == null)
            throw new EventNotFound("There is no event with name " + name + " on date " + date);
        var freeTickets = TicketReporter.getFreeSeats(event);
        StringBuilder sb = new StringBuilder();
        sb.append("All free tickets for event ").append(event.getName())
                .append(" on date ").append(event.getDate())
                .append("\n");
        if (!freeTickets.isEmpty()) {
            for (var ticket : freeTickets) {
                sb.append("\n Free ticket: Row ").append(ticket.getRow()).append(" | Seat ").append(ticket.getSeat());
            }
        } else log("There are no free tickets for the event");

        sb.append("\n");
        log(sb.toString());
    }
}
