package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.contracts.Command;
import bg.tu_varna.sit.b1.f23621684.contracts.CommandParameter;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.ValidatableParameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MenuCommand implements Command {

    private final String commandName;
    private final String commandDescription;
    private final List<ValidatableParameter> commandParameters;

    public MenuCommand(String commandName, String commandDescription) {
        this.commandName = commandName;
        this.commandDescription = commandDescription;
        this.commandParameters = new ArrayList<>();
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public String getCommandDescription() {
        return commandDescription;
    }

    public List<ValidatableParameter> getCommandParameters() {
        return new ArrayList<>(commandParameters);
    }

    public MenuCommand addCommandParameter(ValidatableParameter cp) {
        this.commandParameters.add(cp);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getCommandName());

        for(var param : getCommandParameters())
        {
            sb.append(" ");
            sb.append(param.toString());
        }

        sb.append("\n");
        sb.append("       * ");
        sb.append(getCommandDescription());

        return sb.toString();
    }

    public Map<CommandParameter, String> execute(List<String> input) {

        int inputIndex = 0;
        int paramIndex = 0;

        Map<CommandParameter, String> matchedInput = new HashMap<>();

        while (inputIndex < input.size()) {
            {
                if (paramIndex >= commandParameters.size())
                    return null;

                var passedParam = input.get(inputIndex);
                var commandParam = commandParameters.get(paramIndex);

                if (!commandParam.validate(passedParam)) {
                    if (commandParam.isOptional()) {
                        paramIndex++;
                        continue;
                    } else {
                        return null;
                    }
                }

                matchedInput.put(commandParam, passedParam);
                inputIndex++;
                paramIndex++;
            }
        }
        return matchedInput;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        return getClass() == obj.getClass();
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}
