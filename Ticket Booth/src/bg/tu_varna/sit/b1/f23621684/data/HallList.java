package bg.tu_varna.sit.b1.f23621684.data;

import bg.tu_varna.sit.b1.f23621684.models.Hall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HallList {

    private List<Hall> list;

    private HallList() {
        this.list = new ArrayList<>();
    }

    public List<Hall> getList() {
        return new ArrayList<>(list);
    }

    public void clear() {
        this.list.clear();
    }
    
    public void addHalls(Collection<Hall> halls) {
        this.list.addAll(halls);
    }

    private static class SingletonHelper {
        private static final HallList INSTANCE = new HallList();
    }

    public static HallList getInstance() {
        return SingletonHelper.INSTANCE;
    }
}