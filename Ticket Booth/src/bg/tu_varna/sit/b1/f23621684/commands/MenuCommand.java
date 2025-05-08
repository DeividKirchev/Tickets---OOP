package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.commands.contracts.ParametizedCommand;
import bg.tu_varna.sit.b1.f23621684.exceptions.DataParsingException;
import bg.tu_varna.sit.b1.f23621684.exceptions.InvalidParamException;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.parameters.BaseCommandParameter;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuCommand implements ParametizedCommand, Logger {

    private final String commandName;
    private final String commandDescription;
    private final List<BaseCommandParameter> commandParameters;
    private final Menu menu;

    public MenuCommand(String commandName, String commandDescription, Menu menu) {
        this.commandName = commandName;
        this.commandDescription = commandDescription;
        this.commandParameters = new ArrayList<>();
        this.menu = menu;
    }

    @Override
    public void log(String message) {
        this.menu.getLogger().log(message);
    }

    public Menu getMenu() {
        return menu;
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
    public List<BaseCommandParameter> getCommandParameters() {
        return new ArrayList<>(commandParameters);
    }

    @Override
    public MenuCommand addCommandParameter(BaseCommandParameter cp) {
        this.commandParameters.add(cp);
        return this;
    }

    @Override
    public void setParams(List<String> input) {

        int inputIndex = 0;
        int paramIndex = 0;


        while (inputIndex < input.size()) {
            {
                if (paramIndex >= commandParameters.size())
                    throw new InvalidParamException("Failed to match passed parameters. Please, check the requirements");

                var passedParam = input.get(inputIndex);
                var commandParam = commandParameters.get(paramIndex);

                try {
                    commandParam.extract(passedParam);
                } catch (DataParsingException e) {
                    if (commandParam.isOptional()) {
                        paramIndex++;
                        continue;
                    } else {
                        throw new InvalidParamException("Failed parsing parameter " + commandParam + "\nMessage: " + e.getMessage());
                    }
                }

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

    @Override
    public void execute(List<String> params) {
        setParams(params);
        handleExecute();
    }

    protected abstract void handleExecute();
}
