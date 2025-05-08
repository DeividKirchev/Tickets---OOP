package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.commands.*;
import bg.tu_varna.sit.b1.f23621684.commands.contracts.ParametizedCommand;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;

import java.util.ArrayList;
import java.util.List;


public class TicketBoothMenu extends BaseMenu {


    public TicketBoothMenu(Logger logger) {
        super(logger);
    }

    @Override
    public List<ParametizedCommand> getCommands() {
        List<ParametizedCommand> commandList = new ArrayList<>();

        commandList.add(new HelpCommand(this));
        commandList.add(new OpenCommand(this));
        commandList.add(new CloseCommand(this));
        commandList.add(new SaveCommand(this));
        commandList.add(new SaveAsCommand(this));
        commandList.add(new AddEventCommand(this));
        commandList.add(new ExitCommand(this));

        return commandList;
    }
}
