package bg.tu_varna.sit.b1.f23621684.menu.commands;

import bg.tu_varna.sit.b1.f23621684.exceptions.ExitException;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommand;

import java.util.List;

public class ExitCommand extends MenuCommand {
    public ExitCommand(Logger logger) {
        super("exit", "exists the program", logger);
    }

    @Override
    public void execute(List<String> input) {
        throw new ExitException("Exiting the program...");
    }
}
