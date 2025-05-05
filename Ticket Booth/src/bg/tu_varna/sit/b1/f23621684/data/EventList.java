package bg.tu_varna.sit.b1.f23621684.data;

import bg.tu_varna.sit.b1.f23621684.models.Event;
import bg.tu_varna.sit.b1.f23621684.models.Hall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EventList {

    private List<Event> list;

    private EventList() {
        this.list = new ArrayList<>();
    }

    public List<Event> getList() {
        return new ArrayList<>(list);
    }

    public void clear() {
        this.list.clear();
    }


    private static class SingletonHelper {
        private static final EventList INSTANCE = new EventList();
    }

    public static EventList getInstance() {
        return SingletonHelper.INSTANCE;
    }
}