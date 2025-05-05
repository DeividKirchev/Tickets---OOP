package bg.tu_varna.sit.b1.f23621684.data;

import bg.tu_varna.sit.b1.f23621684.models.Event;

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
}