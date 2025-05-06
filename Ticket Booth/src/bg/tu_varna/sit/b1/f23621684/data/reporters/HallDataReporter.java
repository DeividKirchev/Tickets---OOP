package bg.tu_varna.sit.b1.f23621684.data.reporters;

import bg.tu_varna.sit.b1.f23621684.data.HallList;
import bg.tu_varna.sit.b1.f23621684.models.Hall;

import java.util.List;

public class HallDataReporter {
    private final static HallList hallList = HallList.getInstance();

    public static List<Hall> getList() {
        return hallList.getList();
    }

    public static Hall getById(int hallId) {
        var hallOptional = getList().stream().filter(h -> h.getId() == hallId).findFirst();
        return hallOptional.orElse(null);
    }
}
