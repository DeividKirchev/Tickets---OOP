package bg.tu_varna.sit.b1.f23621684.extractors;

import bg.tu_varna.sit.b1.f23621684.contracts.Value;
import bg.tu_varna.sit.b1.f23621684.exceptions.DataParsingException;
import bg.tu_varna.sit.b1.f23621684.extractors.contracts.Extractor;

public abstract class ValueExtractor<T> implements Extractor, Value<T> {
    @Override
    public void extract(String input) {
        if (input == null)
            throw new DataParsingException("Input is null");
        parse(input);
    }

    protected abstract void parse(String input);

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public void clear() {
        this.setValue(null);
    }
}
