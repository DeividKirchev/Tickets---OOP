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
        List<CommandWithParameters> commandList = new ArrayList<>();

        commandList.add(new HelpCommand(logger, commandList));
        commandList.add(new AddEventCommand());
        commandList.add(new ExitCommand());

        addCommands(commandList);
    }


}
