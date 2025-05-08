package bg.tu_varna.sit.b1.f23621684.commands;


import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;

public class SaveCommand extends MenuCommand {
    public SaveCommand(Menu menu) {
        super("save", "saves the currently open file", menu);
    }

    @Override
    public void handleExecute() {
        var filePath = getMenu().getFilePath();

        SaveAsCommand.saveAs(filePath);

        log("Content saved to file successfuly;");
    }
}