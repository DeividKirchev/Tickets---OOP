package bg.tu_varna.sit.b1.f23621684.menu.commands;

import bg.tu_varna.sit.b1.f23621684.contracts.CommandParameter;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommand;

import java.util.List;
import java.util.Map;

public class HelpCommand extends MenuCommand {
    private final Map<String, MenuCommand> commands;

    public HelpCommand(Map<String, MenuCommand> commands) {
        super("help", "prints this information");
        this.commands = commands;
    }

    @Override
    public Map<CommandParameter, String> execute(List<String> input) {
        StringBuilder sb = new StringBuilder();
        sb.append("The following commands are supported:\n");
        for (var command : commands.values()) {
            sb.append("- ");
            sb.append(command.toString());
            sb.append("\n\n");
        }
        System.out.println(sb);

        return null;
    }
}
