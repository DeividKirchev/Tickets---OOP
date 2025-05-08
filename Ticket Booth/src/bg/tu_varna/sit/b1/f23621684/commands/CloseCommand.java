package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.EventList;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;


public class CloseCommand extends MenuCommand {
    public CloseCommand(Menu menu) {
        super("close", "closes currently opened file", menu);
    }
    @Override
    public void handleExecute() {
        EventList.getInstance().clear();
        getMenu().setFilePath(null);
        log("File closed. Data cleared.");
    }
}
