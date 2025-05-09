package bg.tu_varna.sit.b1.f23621684.data.reporters;

import bg.tu_varna.sit.b1.f23621684.data.EventList;
import bg.tu_varna.sit.b1.f23621684.models.Date;
import bg.tu_varna.sit.b1.f23621684.models.Event;
import bg.tu_varna.sit.b1.f23621684.models.Hall;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventDataReporter {
    private final static EventList eventList = EventList.getInstance();

    public static List<Event> getList() {
        return eventList.getList();
    }

    public static Event getEvent(String name, Date date) {
        var eventOptional = getList().stream().filter(h -> h.getName().equals(name) && h.getDate().equals(date)).findFirst();
        return eventOptional.orElse(null);
    }

    public static List<Event> getEvents(String name, Date date) {
        if (date == null) {
            if (name == null)
                return EventDataReporter.getList();
            else
                return (EventDataReporter.getEvents(name));
        } else {
            if (name == null)
                return (EventDataReporter.getEvents(date));
            else {
                List<Event> events = new ArrayList<>();
                events.add(EventDataReporter.getEvent(name, date));
                return (events);
            }
        }
    }

    public static Event getEvent(Hall hall, Date date) {
        var eventOptional = getList().stream().filter(h -> h.getHall().equals(hall) && h.getDate().equals(date)).findFirst();
        return eventOptional.orElse(null);
    }

    public static List<Event> getEvents(String name) {
        return getList().stream().filter(h -> h.getName().equals(name)).toList();
    }

    public static List<Event> getEvents(Date date) {
        return getList().stream().filter(h -> h.getDate().equals(date)).toList();
    }

    public static List<Event> getEvents(Date from, Date to) {
        return getList().stream().filter(h -> h.getDate().compareTo(from) >= 0 && h.getDate().compareTo(to) <= 0).toList();
    }

    public static List<Event> getEvents(Date from, Date to, Hall hall) {
        if (hall == null)
            return getEvents(from, to);
        return getEvents(from, to).stream().filter(h -> h.getHall().equals(hall)).toList();
    }

    public static List<Event> getMostWatched(int limit) {
        return getList().stream().sorted(Comparator.comparing(o -> o.getTickets().size())).limit(limit).toList();
    }

    public static List<Event> getAllUnderWatchRatio(float ratio, List<Event> events) {
        return events.stream().filter(e -> e.getTickets().size() / ((float) (e.getHall().getSeatsCount())) <= ratio).toList();
    }

    public static List<Event> getAllUnderWatchRatio(float ratio, Date from, Date to) {
        var events = getEvents(from, to);
        return getAllUnderWatchRatio(ratio, events);
    }
}
