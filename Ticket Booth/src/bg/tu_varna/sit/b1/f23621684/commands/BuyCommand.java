package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.reporters.EventDataReporter;
import bg.tu_varna.sit.b1.f23621684.data.reporters.TicketReporter;
import bg.tu_varna.sit.b1.f23621684.exceptions.EventNotFound;
import bg.tu_varna.sit.b1.f23621684.exceptions.InvalidTicket;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.models.SeatInfo;
import bg.tu_varna.sit.b1.f23621684.models.Ticket;
import bg.tu_varna.sit.b1.f23621684.parameters.DateParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.PositiveNumberParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.StringParameter;

public class BuyCommand extends MenuCommand {
    private final DateParameter date;
    private final PositiveNumberParameter row;
    private final PositiveNumberParameter seat;
    private final StringParameter name;

    public BuyCommand(Menu menu) {
        super("buy", "buy a ticket for event <name> on <date> on <row> and <seat>", menu);

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
            throw new EventNotFound("There is event with name " + name + " on date " + date);

        var ticket = TicketReporter.getTicket(event, row, seat);
        if (ticket == null) {
            ticket = new Ticket("", true, new SeatInfo(event, row, seat));
            event.addTicket(ticket);
        }

        if (ticket.isPayed())
            throw new InvalidTicket("Ticked is already bought");

        log("Ticket bought. Unique Code: " + ticket.generateCode() + "\n");
    }
}