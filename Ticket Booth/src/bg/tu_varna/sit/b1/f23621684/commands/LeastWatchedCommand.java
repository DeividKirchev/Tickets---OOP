package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.reporters.EventDataReporter;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.parameters.DateParameter;

public class LeastWatchedCommand extends MenuCommand {
    private final DateParameter from;
    private final DateParameter to;

    public LeastWatchedCommand(Menu menu) {
        super("leastwatched", "show information about events with under 10% visitation for period <from> <to>", menu);

        DateParameter from = new DateParameter("from", false);
        DateParameter to = new DateParameter("to", false);

        this.addCommandParameter(from)
                .addCommandParameter(to);

        this.from = from;
        this.to = to;
    }

    @Override
    public void handleExecute() {

        var events = EventDataReporter.getAllUnderWatchRatio(0.1f);

        StringBuilder sb = new StringBuilder();
        sb.append("Showing information about all events with under 10% watch ratio:\n");
        if (events.isEmpty()) {
            sb.append("No events with under 10% watch ratio!");
        } else {
            for (var event : events) {
                sb.append(" === Event info ===\n").append(event.toString());
            }
        }

        sb.append("\n");
        log(sb.toString());


    }
}
