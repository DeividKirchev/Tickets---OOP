package bg.tu_varna.sit.b1.f23621684.commands;


import bg.tu_varna.sit.b1.f23621684.data.EventList;
import bg.tu_varna.sit.b1.f23621684.data_handlers.CSVEventListConverter;
import bg.tu_varna.sit.b1.f23621684.exceptions.InvalidParamException;
import bg.tu_varna.sit.b1.f23621684.files.TextFileHandler;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.parameters.StringParameter;

import java.io.IOException;

public class SaveAsCommand extends MenuCommand {
    private StringParameter file;

    public SaveAsCommand(Menu menu) {
        super("saveas", "saves the currently open file in <file>", menu);

        StringParameter file = new StringParameter("file", false);

        addCommandParameter(file);
        this.file = file;
    }

    public static void saveAs(String filePath) {

        var fileHandler = new TextFileHandler();
        try {
            var eventList = EventList.getInstance().getList();
            fileHandler.writeFile(filePath, new CSVEventListConverter().save(eventList));
        } catch (IOException e) {
            throw new InvalidParamException("Error saving to file: " + filePath);
        }
    }

    public void handleExecute() {
        var filePath = file.getValue();
        saveAs(filePath);

        log("Content saved to file successfully;");
    }
}