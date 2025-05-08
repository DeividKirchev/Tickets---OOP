package bg.tu_varna.sit.b1.f23621684.commands.contracts;

import bg.tu_varna.sit.b1.f23621684.contracts.Command;
import bg.tu_varna.sit.b1.f23621684.parameters.BaseCommandParameter;

import java.util.List;

public interface ParametizedCommand extends Command {
    void setParams(List<String> input);

    ParametizedCommand addCommandParameter(BaseCommandParameter cp);

    List<BaseCommandParameter> getCommandParameters();
}
