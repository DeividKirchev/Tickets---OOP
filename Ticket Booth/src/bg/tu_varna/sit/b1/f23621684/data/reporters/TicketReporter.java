package bg.tu_varna.sit.b1.f23621684.data.reporters;

import bg.tu_varna.sit.b1.f23621684.models.*;

import java.util.ArrayList;
import java.util.List;

public class TicketReporter {
    public static List<Ticket> getList(Event e) {
        return e.getTickets();
    }

    public static List<SeatInfo> getFreeSeats(Event e) {
        var tickets = getList(e);
        var result = new ArrayList<SeatInfo>();
        for (int rowIndex = 1; rowIndex <= e.getHall().getRows(); rowIndex++) {
            for (int seatIndex = 1; seatIndex <= e.getHall().getSeatsPerRow(); seatIndex++) {
                var seatInfo = new SeatInfo(e, rowIndex, seatIndex);
                var tmpTicket = new Ticket("", false, seatInfo);
                if (tickets.contains(tmpTicket))
                    continue;
                result.add(seatInfo);
            }
        }
        return result;
    }

    public static List<Ticket> getBookedTickets(Date date, String name) {
        var events = EventDataReporter.getEvents(name, date);

        List<Ticket> bookedTickets = new ArrayList<>();
        for (var event : events) {
            for (var ticket : event.getTickets()) {
                if (!ticket.isPayed())
                    bookedTickets.add(ticket);
            }
        }
        return bookedTickets;
    }

    public static List<Ticket> getPayedTickets(Date from, Date to, Hall hall) {
        var events = EventDataReporter.getEvents(from, to, hall);

        List<Ticket> bookedTickets = new ArrayList<>();
        for (var event : events) {
            for (var ticket : event.getTickets()) {
                if (!ticket.isPayed())
                    bookedTickets.add(ticket);
            }
        }
        return bookedTickets;
    }
}
