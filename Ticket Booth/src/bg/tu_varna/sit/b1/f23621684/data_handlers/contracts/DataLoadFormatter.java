package bg.tu_varna.sit.b1.f23621684.data_handlers.contracts;

public interface DataLoadFormatter<T, K> {
    T load(K data);
}
