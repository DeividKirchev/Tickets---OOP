package bg.tu_varna.sit.b1.f23621684.data;

import bg.tu_varna.sit.b1.f23621684.data.reporters.EventDataReporter;
import bg.tu_varna.sit.b1.f23621684.exceptions.EventAlreadyCreated;
import bg.tu_varna.sit.b1.f23621684.exceptions.HallAlreadyBookedException;
import bg.tu_varna.sit.b1.f23621684.models.Event;

import java.util.Collection;

public class EventList extends DataList<Event> {

    private EventList() {
        super();
    }

    private static class SingletonHelper {
        private static final EventList INSTANCE = new EventList();
    }

    public static EventList getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public void add(Event data) {
        if (EventDataReporter.getEvent(data.getHall(), data.getDate()) != null)
            throw new HallAlreadyBookedException("Hall is already booked for the date");
        if (EventDataReporter.getEvent(data.getName(), data.getDate()) != null)
            throw new EventAlreadyCreated("Event already added for the date.");
        super.add(data);
    }

    @Override
    public void add(Collection<Event> data) {
        for (var event : data)
            add(event);
    }
}