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

}