package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.encoders.TicketEncoder;
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
        var seatInfo = TicketEncoder.decode(this.code.getValue());
        log("Code is valid\n");
        log(" === Seat information === ");
        log(seatInfo.toString());
    }
}
