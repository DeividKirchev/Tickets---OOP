package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.contracts.CommandParameter;
import bg.tu_varna.sit.b1.f23621684.contracts.CommandWithParameters;
import bg.tu_varna.sit.b1.f23621684.exceptions.InvalidParamException;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.ValidatableParameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MenuCommand implements CommandWithParameters, Logger {

    private final String commandName;
    private final String commandDescription;
    private final List<ValidatableParameter> commandParameters;
    private final Logger logger;

    public MenuCommand(String commandName, String commandDescription, Logger logger) {
        this.commandName = commandName;
        this.commandDescription = commandDescription;
        this.commandParameters = new ArrayList<>();
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        this.logger.log(message);
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public String getCommandDescription() {
        return commandDescription;
    }

    @Override
    public List<ValidatableParameter> getCommandParameters() {
        return new ArrayList<>(commandParameters);
    }

    @Override
    public MenuCommand addCommandParameter(ValidatableParameter cp) {
        this.commandParameters.add(cp);
        return this;
    }

    @Override
    public Map<CommandParameter, String> getMappedParams(List<String> input) {

        int inputIndex = 0;
        int paramIndex = 0;

        Map<CommandParameter, String> matchedInput = new HashMap<>();

        while (inputIndex < input.size()) {
            {
                if (paramIndex >= commandParameters.size())
                    throw new InvalidParamException("Failed to match passed parameters. Please, check the requirements");

                var passedParam = input.get(inputIndex);
                var commandParam = commandParameters.get(paramIndex);

                var validation = commandParam.validate(passedParam);
                if (validation != null) {
                    if (commandParam.isOptional()) {
                        paramIndex++;
                        continue;
                    } else {
                        throw new InvalidParamException("Failed parsing parameter " + commandParam + "\nMessage: " + validation);
                    }
                }

                matchedInput.put(commandParam, passedParam);

                inputIndex++;
                paramIndex++;
            }
        }

        for (; paramIndex < commandParameters.size(); paramIndex++) {
            var cmdParam = commandParameters.get(paramIndex);
            if (cmdParam.isOptional())
                continue;
            throw new InvalidParamException("Missing parameters. Please, check the requirements.");
        }

        return matchedInput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getCommandName());

        for (var param : getCommandParameters()) {
            sb.append(" ");
            sb.append(param.toString());
        }

        sb.append("\n");
        sb.append("       * ");
        sb.append(getCommandDescription());

        return sb.toString();
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
