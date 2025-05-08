package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.reporters.TicketReporter;
import bg.tu_varna.sit.b1.f23621684.encoders.TicketEncoder;
import bg.tu_varna.sit.b1.f23621684.exceptions.InvalidCodeException;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.parameters.StringParameter;

public class CheckCodeCommand extends MenuCommand {
    private final StringParameter code;

    public CheckCodeCommand(Menu menu) {
        super("check", "check and show information about a ticket code", menu);

        StringParameter code = new StringParameter("code", false);

        this.addCommandParameter(code);

        this.code = code;
    }

    @Override
    public void handleExecute() {
        var seatInfo = TicketEncoder.decode(this.code.getValue(), null);
        var ticket = TicketReporter.getTicket(seatInfo.getEvent(), seatInfo.getRow(), seatInfo.getSeat());
        if (!ticket.isPayed())
            throw new InvalidCodeException("Seat is booked, but no ticket is bought");
        log("Code is valid\n");
        log("Seat information\n");
        log(seatInfo.toString());
    }
}
