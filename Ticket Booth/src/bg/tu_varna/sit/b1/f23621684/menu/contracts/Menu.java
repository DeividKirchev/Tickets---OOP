package bg.tu_varna.sit.b1.f23621684.menu.contracts;

import bg.tu_varna.sit.b1.f23621684.commands.contracts.ParametizedCommand;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;

import java.util.List;

public interface Menu extends FileLink {
    void startMenu();

    Logger getLogger();

    List<ParametizedCommand> getCommands();


}
