package bg.tu_varna.sit.b1.f23621684.menu.commands;

import bg.tu_varna.sit.b1.f23621684.contracts.CommandParameter;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommand;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommandParameter;
import bg.tu_varna.sit.b1.f23621684.validators.DateValidator;
import bg.tu_varna.sit.b1.f23621684.validators.IntegerValidator;
import bg.tu_varna.sit.b1.f23621684.validators.StringValidator;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.ValidatableParameter;

import java.util.List;
import java.util.Map;

public class AddEventCommand extends MenuCommand {
    public AddEventCommand() {
        super("addevent", "add a new event on <date> with <name> in hall <hall>");

        ValidatableParameter date = new MenuCommandParameter("date", false);
        date.addValidator(new DateValidator());

        ValidatableParameter hall = new MenuCommandParameter("hall", false);
        hall.addValidator(new IntegerValidator());

        ValidatableParameter name = new MenuCommandParameter("name", false);
        name.addValidator(new StringValidator());

        this.addCommandParameter(date).addCommandParameter(hall).addCommandParameter(name);
    }

    @Override
    public Map<CommandParameter, String> execute(List<String> input) {
        var data = super.execute(input);
        if (data == null) return null;
        return null;
    }
}
