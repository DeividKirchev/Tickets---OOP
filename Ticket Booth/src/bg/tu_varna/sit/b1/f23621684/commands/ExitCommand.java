package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.exceptions.ExitException;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;


public class ExitCommand extends MenuCommand {
    public ExitCommand(Menu menu) {
        super("exit", "exists the program", menu);
    }

    @Override
    public void handleExecute() {
        throw new ExitException("Exiting the program...");
    }
}
