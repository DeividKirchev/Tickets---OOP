package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.reporters.EventDataReporter;
import bg.tu_varna.sit.b1.f23621684.data.reporters.TicketReporter;
import bg.tu_varna.sit.b1.f23621684.exceptions.EventNotFound;
import bg.tu_varna.sit.b1.f23621684.exceptions.InvalidTicket;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.parameters.DateParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.PositiveNumberParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.StringParameter;

public class UnbookCommand extends MenuCommand {
    private final DateParameter date;
    private final PositiveNumberParameter row;
    private final PositiveNumberParameter seat;
    private final StringParameter name;

    public UnbookCommand(Menu menu) {
        super("unbook", "unbook a ticket for event <name> on <date> on <row> and <seat>", menu);

        DateParameter date = new DateParameter("date", false);
        PositiveNumberParameter row = new PositiveNumberParameter("row", false);
        PositiveNumberParameter seat = new PositiveNumberParameter("seat", false);
        StringParameter name = new StringParameter("name", false);

        this.addCommandParameter(row)
                .addCommandParameter(seat)
                .addCommandParameter(date)
                .addCommandParameter(name);

        this.date = date;
        this.row = row;
        this.seat = seat;
        this.name = name;
    }

    @Override
    public void handleExecute() {

        var date = this.date.getValue();
        var name = this.name.getValue();
        var seat = this.seat.getValue();
        var row = this.row.getValue();

        var event = EventDataReporter.getEvent(name, date);
        if (event == null)
            throw new EventNotFound("There is no event with name " + name + " on date " + date);

        var ticket = TicketReporter.getTicket(event, row, seat);
        if (ticket == null)
            throw new InvalidTicket("No such reservation exists.");
        if (ticket.isPayed())
            throw new InvalidTicket("Ticket is already payed for, cannot unbook");

        event.removeTicket(ticket);

        log("Successfully unbooked ticket\n");
    }
}