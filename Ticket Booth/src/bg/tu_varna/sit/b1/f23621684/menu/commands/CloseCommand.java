package bg.tu_varna.sit.b1.f23621684.menu.commands;

import bg.tu_varna.sit.b1.f23621684.data.EventList;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommand;

import java.util.List;

public class CloseCommand extends MenuCommand {
    public CloseCommand(Logger logger) {
        super("close", "closes currently opened file\n", logger);
    }

    @Override
    public void execute(List<String> input) {
        EventList.getInstance().clear();
        log("File closed. Data cleared.");
    }
}
