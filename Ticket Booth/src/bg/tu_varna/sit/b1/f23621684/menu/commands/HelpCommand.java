package bg.tu_varna.sit.b1.f23621684.menu.commands;

import bg.tu_varna.sit.b1.f23621684.contracts.CommandWithParameters;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommand;

import java.util.List;

public class HelpCommand extends MenuCommand {
    private final List<CommandWithParameters> commands;

    public HelpCommand(Logger logger, List<CommandWithParameters> commands) {
        super("help", "prints this information", logger);
        this.commands = commands;
    }

    @Override
    public void execute(List<String> input) {
        StringBuilder sb = new StringBuilder();
        sb.append("The following commands are supported:\n");
        for (var command : commands) {
            sb.append("- ");
            sb.append(command.toString());
            sb.append("\n\n");
        }
        log(sb.toString());
    }
}
