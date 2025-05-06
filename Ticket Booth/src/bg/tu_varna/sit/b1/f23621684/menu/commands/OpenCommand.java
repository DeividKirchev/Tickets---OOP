package bg.tu_varna.sit.b1.f23621684.menu.commands;

import bg.tu_varna.sit.b1.f23621684.data.EventList;
import bg.tu_varna.sit.b1.f23621684.data_handlers.CSVEventListConverter;
import bg.tu_varna.sit.b1.f23621684.exceptions.InvalidParamException;
import bg.tu_varna.sit.b1.f23621684.files.TextFileHandler;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommand;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommandParameter;
import bg.tu_varna.sit.b1.f23621684.validators.input.StringInputValidator;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.ValidatableParameter;

import java.io.IOException;
import java.util.List;

public class OpenCommand extends MenuCommand {
    private ValidatableParameter file;

    public OpenCommand(Logger logger) {
        super("open", "opens <file>", logger);

        ValidatableParameter file = new MenuCommandParameter("file", false);
        file.addValidator(new StringInputValidator());

        addCommandParameter(file);
        this.file = file;
    }

    @Override
    public void execute(List<String> input) {
        var params = super.getMappedParams(input);
        if (params == null) return;

        var filePath = params.get(file);

        var fileHandler = new TextFileHandler();
        try {
            var data = fileHandler.readFile(filePath);
            var eventList = (new CSVEventListConverter()).load(data);
            var eventListInstance = EventList.getInstance();
            eventListInstance.clear();
            eventListInstance.add(eventList);
        } catch (IOException e) {
            throw new InvalidParamException("Error loading file: " + filePath);
        }

        log("File opened and content loaded.");
    }
}
