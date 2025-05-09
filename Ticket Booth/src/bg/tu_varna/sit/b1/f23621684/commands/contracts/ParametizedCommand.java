package bg.tu_varna.sit.b1.f23621684.commands.contracts;

import bg.tu_varna.sit.b1.f23621684.parameters.contracts.CommandParameter;

import java.util.List;

public interface ParametizedCommand extends Command {
    void setParams(List<String> input);

    ParametizedCommand addCommandParameter(CommandParameter cp);

    List<CommandParameter> getCommandParameters();
}
