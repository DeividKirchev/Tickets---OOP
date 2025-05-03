package bg.tu_varna.sit.b1.f23621684.contracts;

import bg.tu_varna.sit.b1.f23621684.validators.contracts.ValidatableParameter;

import java.util.List;
import java.util.Map;

public interface CommandWithParameters extends Command {
    Map<CommandParameter, String> getMappedParams(List<String> input);

    CommandWithParameters addCommandParameter(ValidatableParameter cp);

    List<ValidatableParameter> getCommandParameters();
}
