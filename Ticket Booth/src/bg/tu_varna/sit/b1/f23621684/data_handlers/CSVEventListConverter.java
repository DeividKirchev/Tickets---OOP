package bg.tu_varna.sit.b1.f23621684.data_handlers;

import bg.tu_varna.sit.b1.f23621684.data.reporters.HallDataReporter;
import bg.tu_varna.sit.b1.f23621684.data_handlers.contracts.DataFormatConverter;
import bg.tu_varna.sit.b1.f23621684.exceptions.DataFormatException;
import bg.tu_varna.sit.b1.f23621684.exceptions.SeatAlreadyBooked;
import bg.tu_varna.sit.b1.f23621684.models.*;

import java.util.ArrayList;
import java.util.List;

public class CSVEventListConverter implements DataFormatConverter<List<Event>, String> {

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
            if (tokens.length < 4)
                throw new DataFormatException("Invalid format at line " + lineNumber + ": " + line);

            try {
                int hallId = Integer.parseInt(tokens[0].trim());
                String eventName = tokens[1].trim();
                Date eventDate = new Date();
                eventDate.fromString(tokens[2]);
                int ticketCount = Integer.parseInt(tokens[3].trim());

                Hall hall = HallDataReporter.getById(hallId);
                if (hall == null)
                    throw new DataFormatException("No hall exists with id: " + hallId);
                Event event = new Event(hall, eventName, eventDate);

                int expectedLength = 4 + ticketCount * 3;
                if (tokens.length != expectedLength)
                    throw new DataFormatException("Invalid ticket data at line " + lineNumber + ": " + line);

                for (int i = 0; i < ticketCount; i++) {
                    int baseIndex = 4 + i * 3;
                    String note = tokens[baseIndex].trim();
                    String code = tokens[baseIndex + 1].trim();
                    boolean isPayed = Boolean.parseBoolean(tokens[baseIndex + 2].trim());
                    SeatInfo si = new SeatInfo(event,code);
                    Ticket ticket = new Ticket(note, isPayed, si);
                    event.addTicket(ticket);
                }
                events.add(event);

            } catch (NumberFormatException e) {
                throw new DataFormatException("Invalid format at line " + lineNumber + ": " + line);
            } catch (SeatAlreadyBooked e) {
                throw new DataFormatException("Invalid ticket at line " + lineNumber + ": " + line);
            }
        }
        return events;
    }

    @Override
    public String save(List<Event> data) {
        StringBuilder sb = new StringBuilder();
        for (Event event : data) {
            sb.append(event.getHall().getId()).append(",")
                    .append(event.getName()).append(",")
                    .append(event.getDate()).append(",")
                    .append(event.getTickets().size());

            for (Ticket ticket : event.getTickets()) {
                sb.append(",").append(ticket.getNote())
                        .append(",").append(ticket.generateCode())
                        .append(",").append(ticket.isPayed());
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
