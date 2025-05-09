package bg.tu_varna.sit.b1.f23621684.commands.contracts;

import bg.tu_varna.sit.b1.f23621684.contracts.Executable;

public interface Command extends Executable {
    String getCommandName();
    String getCommandDescription();
}
