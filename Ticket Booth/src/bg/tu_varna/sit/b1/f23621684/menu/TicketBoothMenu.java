package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.contracts.CommandWithParameters;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.commands.AddEventCommand;
import bg.tu_varna.sit.b1.f23621684.menu.commands.ExitCommand;
import bg.tu_varna.sit.b1.f23621684.menu.commands.HelpCommand;

import java.util.ArrayList;
import java.util.List;


public class TicketBoothMenu extends BaseMenu {


    public TicketBoothMenu(Logger logger) {
        super(logger);
    }

    @Override
    public List<CommandWithParameters> getCommands() {
        List<CommandWithParameters> commandList = new ArrayList<>();

        commandList.add(new HelpCommand(this.getLogger(), commandList));
        commandList.add(new AddEventCommand(this.getLogger()));
        commandList.add(new ExitCommand(this.getLogger()));

        return commandList;
    }
}
