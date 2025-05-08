package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.reporters.EventDataReporter;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;

public class MostWatchedCommand extends MenuCommand {
    public MostWatchedCommand(Menu menu) {
        super("mostwatched", "shows information about the 10 most watched events", menu);
    }

    @Override
    public void handleExecute() {

        var events = EventDataReporter.getMostWatched(10);

        StringBuilder sb = new StringBuilder();
        sb.append("Showing information about all bookins:\n");
        if (events.isEmpty()) {
            sb.append("No events!");
        } else {
            for (var event : events) {
                sb.append(" === Event info ===\n").append(event.toString());
            }
        }

        sb.append("\n");
        log(sb.toString());
    }
}