package bg.tu_varna.sit.b1.f23621684.data_handlers;

import bg.tu_varna.sit.b1.f23621684.data_handlers.contracts.DataFormatConverter;
import bg.tu_varna.sit.b1.f23621684.exceptions.DataFormatException;
import bg.tu_varna.sit.b1.f23621684.models.Date;
import bg.tu_varna.sit.b1.f23621684.models.Event;
import bg.tu_varna.sit.b1.f23621684.models.Hall;
import bg.tu_varna.sit.b1.f23621684.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class CSVEventListConverter implements DataFormatConverter<List<Event>, String> {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public List<Event> load(String data) {
        List<Event> events = new ArrayList<>();
        String[] lines = data.split("\n");
        int lineNumber = 0;
        for (String line : lines) {
            lineNumber++;
            line = line.trim();
            if (line.isEmpty()) continue;
            String[] tokens = line.split(",");
            if (tokens.length < 6)
                throw new DataFormatException("Invalid format at line " + lineNumber + ": " + line);

            try {
                int hallId = Integer.parseInt(tokens[0].trim());
                int rows = Integer.parseInt(tokens[1].trim());
                int seatsPerRow = Integer.parseInt(tokens[2].trim());
                String eventName = tokens[3].trim();
                Date eventDate = new Date();
                eventDate.fromString(tokens[4]);
                int ticketCount = Integer.parseInt(tokens[5].trim());

                Hall hall = new Hall(hallId, rows, seatsPerRow);
                Event event = new Event(hall, eventName, eventDate);

                int expectedLength = 6 + ticketCount * 3;
                if (tokens.length != expectedLength)
                    throw new DataFormatException("Invalid ticket data at line " + lineNumber + ": " + line);

                for (int i = 0; i < ticketCount; i++) {
                    int baseIndex = 6 + i * 3;
                    int note = Integer.parseInt(tokens[baseIndex].trim());
                    String code = tokens[baseIndex + 1].trim();
                    boolean isPayed = Boolean.parseBoolean(tokens[baseIndex + 2].trim());
                    Ticket ticket = new Ticket(note, isPayed);
                    ticket.setCode(code);
                    event.addTicket(ticket);
                }

                events.add(event);
            } catch (NumberFormatException e) {
                throw new DataFormatException("Invalid format at line " + lineNumber + ": " + line);
            }
        }
        return events;
    }

    @Override
    public String save(List<Event> data) {
        StringBuilder sb = new StringBuilder();
        for (Event event : data) {
            sb.append(event.getHall().getId()).append(",")
                    .append(event.getHall().getRows()).append(",")
                    .append(event.getHall().getSeatsPerRow()).append(",")
                    .append(event.getName()).append(",")
                    .append(event.getDate()).append(",")
                    .append(event.getTickets().size());

            for (Ticket ticket : event.getTickets()) {
                sb.append(",").append(ticket.getNote())
                        .append(",").append(ticket.getCode())
                        .append(",").append(ticket.isPayed());
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
