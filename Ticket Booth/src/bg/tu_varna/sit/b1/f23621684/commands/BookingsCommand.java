package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.reporters.TicketReporter;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.parameters.DateParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.StringParameter;

public class BookingsCommand extends MenuCommand {
    private final DateParameter date;
    private final StringParameter name;

    public BookingsCommand(Menu menu) {
        super("bookings", "show information about all booked (unpaid) tickets for event <name> on <date>", menu);

        DateParameter date = new DateParameter("date", true);
        StringParameter name = new StringParameter("name", true);

        this.addCommandParameter(date)
                .addCommandParameter(name);

        this.date = date;
        this.name = name;
    }

    @Override
    public void handleExecute() {

        var date = this.date.getValue();
        var name = this.name.getValue();

        var tickets = TicketReporter.getBookedTickets(date, name);

        StringBuilder sb = new StringBuilder();
        sb.append("Showing information about bookings:\n");
        if (tickets.isEmpty()) {
            sb.append("No booked tickets!");
        } else {
            for (var ticket : tickets) {
                sb.append(" === Booked ticket ===\n").append(ticket.toString());
            }
        }

        sb.append("\n");
        log(sb.toString());
    }
}
