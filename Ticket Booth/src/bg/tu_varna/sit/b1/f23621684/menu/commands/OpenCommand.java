package bg.tu_varna.sit.b1.f23621684.menu.commands;

import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommand;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommandParameter;
import bg.tu_varna.sit.b1.f23621684.validators.StringValidator;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.ValidatableParameter;

import java.util.List;

public class OpenCommand extends MenuCommand {
    private ValidatableParameter file;

    public OpenCommand(Logger logger) {
        super("open", "opens <file>", logger);

        ValidatableParameter file = new MenuCommandParameter("file", false);
        file.addValidator(new StringValidator());

        addCommandParameter(file);
        this.file = file;
    }

    @Override
    public void execute(List<String> input) {
        log("File opened and content loaded.");
    }
}
