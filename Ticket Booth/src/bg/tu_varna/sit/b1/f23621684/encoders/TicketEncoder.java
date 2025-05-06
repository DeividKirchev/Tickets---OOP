package bg.tu_varna.sit.b1.f23621684.encoders;

import bg.tu_varna.sit.b1.f23621684.data.reporters.EventDataReporter;
import bg.tu_varna.sit.b1.f23621684.exceptions.EventNotFound;
import bg.tu_varna.sit.b1.f23621684.models.Date;
import bg.tu_varna.sit.b1.f23621684.models.Event;
import bg.tu_varna.sit.b1.f23621684.models.SeatInfo;

import java.time.LocalDateTime;
import java.util.Base64;

public class TicketEncoder {

    public static String encode(SeatInfo seatInfo) {
        String eventName = seatInfo.getEvent().getName();
        Date date = seatInfo.getEvent().getDate();
        int row = seatInfo.getRow();
        int seat = seatInfo.getSeat();
        String combined = String.join("|", eventName, date.toString(), String.valueOf(row), String.valueOf(seat), LocalDateTime.now().toString());
        byte[] bytes = combined.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static SeatInfo decode(String encoded) {
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        String decodedString = new String(decodedBytes);
        String[] parts = decodedString.split("\\|");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid encoded data");
        }
        Date date = new Date(parts[1]);
        Event event = EventDataReporter.getEvent(parts[0], date);
        if (event == null) throw new EventNotFound("Could not find event " + parts[0] + " on date " + date);
        return new SeatInfo(event, Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
    }
}
