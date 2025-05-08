package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.reporters.EventDataReporter;
import bg.tu_varna.sit.b1.f23621684.data.reporters.TicketReporter;
import bg.tu_varna.sit.b1.f23621684.exceptions.EventNotFound;
import bg.tu_varna.sit.b1.f23621684.exceptions.SeatAlreadyBooked;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.models.SeatInfo;
import bg.tu_varna.sit.b1.f23621684.models.Ticket;
import bg.tu_varna.sit.b1.f23621684.parameters.DateParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.PositiveNumberParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.StringParameter;

public class BookCommand extends MenuCommand {
    private final DateParameter date;
    private final PositiveNumberParameter row;
    private final PositiveNumberParameter seat;
    private final StringParameter note;
    private final StringParameter name;

    public BookCommand(Menu menu) {
        super("book", "book a ticket for event <name> on <date> on <row> and <seat> with a <note>", menu);

        DateParameter date = new DateParameter("date", false);
        StringParameter note = new StringParameter("note", false);
        PositiveNumberParameter row = new PositiveNumberParameter("row", false);
        PositiveNumberParameter seat = new PositiveNumberParameter("seat", false);
        StringParameter name = new StringParameter("name", false);

        this.addCommandParameter(row)
                .addCommandParameter(seat)
                .addCommandParameter(date)
                .addCommandParameter(name)
                .addCommandParameter(note);

        this.date = date;
        this.row = row;
        this.seat = seat;
        this.note = note;
        this.name = name;
    }

    @Override
    public void handleExecute() {

        var date = this.date.getValue();
        var name = this.name.getValue();
        var note = this.note.getValue();
        var seat = this.seat.getValue();
        var row = this.row.getValue();

        var event = EventDataReporter.getEvent(name, date);
        if (event == null)
            throw new EventNotFound("There is event with name " + name + " on date " + date);

        var ticket = TicketReporter.getTicket(event, row, seat);
        if (ticket != null)
            throw new SeatAlreadyBooked("Seat is already booked");

        ticket = new Ticket(note, false, new SeatInfo(event, row, seat));

        event.addTicket(ticket);
        log("Successfully booked ticket\n");
    }
}