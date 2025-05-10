package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.reporters.EventDataReporter;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.parameters.DateParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.HallParameter;

public class ReportCommand extends MenuCommand {
    private final DateParameter from;
    private final DateParameter to;
    private final HallParameter hall;

    public ReportCommand(Menu menu) {
        super("report", "show information about all paid tickets for period <from> <to> for <hall>", menu);

        DateParameter from = new DateParameter("from", false);
        DateParameter to = new DateParameter("to", false);
        HallParameter hall = new HallParameter("hall", true);

        this.addCommandParameter(from)
                .addCommandParameter(to)
                .addCommandParameter(hall);

        this.from = from;
        this.to = to;
        this.hall = hall;
    }

    @Override
    public void handleExecute() {
        var from = this.from.getValue();
        var to = this.to.getValue();
        var hall = this.hall.getValue();

        var events = EventDataReporter.getReport(from, to, hall);

        StringBuilder sb = new StringBuilder();
        sb.append("Event Report:\n");

        if (events.isEmpty()) {
            sb.append("No events found");
        } else {
            for (var event : events) {
                sb.append("=== Event ===\n").append(event.toString());
            }
        }

        log(sb.toString());
    }
}
