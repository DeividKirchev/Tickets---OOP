package bg.tu_varna.sit.b1.f23621684.data_handlers.contracts;

public interface DataSaveFormatter<T, K> {
    K save(T data);
}
