package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;

public class HelpCommand extends MenuCommand {

    public HelpCommand(Menu menu) {
        super("help", "prints this information", menu);
    }

    @Override
    public void handleExecute() {
        StringBuilder sb = new StringBuilder();
        sb.append("The following commands are supported:\n");
        for (var command : getMenu().getCommands()) {
            sb.append("- ");
            sb.append(command.toString());
            sb.append("\n\n");
        }
        log(sb.toString());
    }
}
