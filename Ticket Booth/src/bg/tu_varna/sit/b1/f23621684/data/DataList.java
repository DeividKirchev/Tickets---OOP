package bg.tu_varna.sit.b1.f23621684.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataList<T> {
    private List<T> list;

    public DataList() {
        list = new ArrayList<>();
    }

    public List<T> getList() {
        return new ArrayList<>(list);
    }

    public void clear() {
        list.clear();
    }

    public void add(Collection<T> data) {
        list.addAll(data);
    }

    public void add(T data) {
        list.add(data);
    }
}
