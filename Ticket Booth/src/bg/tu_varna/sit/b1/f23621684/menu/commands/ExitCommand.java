package bg.tu_varna.sit.b1.f23621684.menu.commands;

import bg.tu_varna.sit.b1.f23621684.contracts.CommandParameter;
import bg.tu_varna.sit.b1.f23621684.exceptions.ExitException;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommand;

import java.util.List;
import java.util.Map;

public class ExitCommand extends MenuCommand {
    public ExitCommand() {
        super("exit", "exists the program");
    }

    @Override
    public void execute(List<String> input) {
        throw new ExitException("Exiting the program...");
    }
}
