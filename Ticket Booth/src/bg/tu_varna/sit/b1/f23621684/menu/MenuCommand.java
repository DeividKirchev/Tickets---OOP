package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.contracts.ICommandParameter;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.IMenuCommand;
import bg.tu_varna.sit.b1.f23621684.validators.CommandParameterValidator;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuCommand implements IMenuCommand {

    private final String commandName;
    private final List<ICommandParameter> commandParameters;

    public MenuCommand(String commandName) {
        this.commandName = commandName;
        this.commandParameters = new ArrayList<>();
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public List<ICommandParameter> getCommandParameters() {
        return new ArrayList<>(commandParameters);
    }

    @Override
    public void addCommandParameter(ICommandParameter cp) {
        this.commandParameters.add(cp);
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

        return sb.toString();
    }

    @Override
    public boolean execute(List<String> params) {
        CommandParameterValidator validator = new CommandParameterValidator(this.getCommandParameters(), params);
        return validator.validate();
    }
}
