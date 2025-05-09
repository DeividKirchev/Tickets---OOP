package bg.tu_varna.sit.b1.f23621684.commands;

import bg.tu_varna.sit.b1.f23621684.data.reporters.EventDataReporter;
import bg.tu_varna.sit.b1.f23621684.files.TextFileHandler;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;
import bg.tu_varna.sit.b1.f23621684.parameters.DateParameter;
import bg.tu_varna.sit.b1.f23621684.parameters.StringParameter;

import java.io.IOException;

public class LeastWatchedCommand extends MenuCommand {
    private final DateParameter from;
    private final DateParameter to;
    private final StringParameter file;

    public LeastWatchedCommand(Menu menu) {
        super("leastwatched", "show information about events with under 10% visitation for period <from> <to> and save it in <file>", menu);

        DateParameter from = new DateParameter("from", false);
        DateParameter to = new DateParameter("to", false);
        StringParameter file = new StringParameter("file", true);

        this.addCommandParameter(from)
                .addCommandParameter(to)
                .addCommandParameter(file);

        this.from = from;
        this.to = to;
        this.file = file;
    }

    @Override
    public void handleExecute() {
        var from = this.from.getValue();
        var to = this.to.getValue();
        var file = this.file.getValue();

        var events = EventDataReporter.getAllUnderWatchRatio(0.1f, from, to);

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
        var info = sb.toString();
        log(info);

        if (file != null) {
            TextFileHandler txt = new TextFileHandler();
            try {
                txt.writeFile(file, info);
                log("Data saved to file successfully");
            } catch (IOException e) {
                log("Could not open file!");
            }
        }

    }
}
