package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.EventList;
import bg.tu_varna.sit.b1.f23621684.data_handlers.CSVEventListConverter;
import bg.tu_varna.sit.b1.f23621684.exceptions.InvalidParamException;
import bg.tu_varna.sit.b1.f23621684.files.TextFileHandler;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.parameters.StringParameter;

import java.io.IOException;
import java.io.File;

public class OpenCommand extends MenuCommand {
    private final StringParameter file;

    public OpenCommand(Menu menu) {
        super("open", "opens <file>", menu);

        StringParameter file = new StringParameter("file", false);
        addCommandParameter(file);
        this.file = file;
    }

    @Override
    public boolean requiresOpenedFile() {
        return false;
    }

    @Override
    public void handleExecute() {

        var filePath = file.getValue();
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
        getMenu().setFilePath(filePath);
        log("File opened and content loaded.");
    }
}
