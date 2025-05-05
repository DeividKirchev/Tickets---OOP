package bg.tu_varna.sit.b1.f23621684.data;

import bg.tu_varna.sit.b1.f23621684.models.Hall;

public class HallList extends DataList<Hall> {

    private HallList() {
        super();
    }

    private static class SingletonHelper {
        private static final HallList INSTANCE = new HallList();
    }

    public static HallList getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public Hall getById(int hallId) {
        var hallOptional = getList().stream().filter(h -> h.getId() == hallId).findFirst();
        return hallOptional.orElse(null);
    }
}