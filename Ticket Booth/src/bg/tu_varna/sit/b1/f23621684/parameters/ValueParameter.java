package bg.tu_varna.sit.b1.f23621684.parameters;

import bg.tu_varna.sit.b1.f23621684.contracts.Value;
import bg.tu_varna.sit.b1.f23621684.extractors.ValueExtractor;

public abstract class ValueParameter<T> extends BaseCommandParameter implements Value<T> {
    private final ValueExtractor<T> extractor;

    public ValueParameter(String name, boolean optional, ValueExtractor<T> extractor) {
        super(name, optional);
        this.extractor = extractor;
    }

    @Override
    public T getValue() {
        return extractor.getValue();
    }

    @Override
    public void setValue(T value) {
        extractor.setValue(value);
    }

    @Override
    public void extract(String input) {
        extractor.extract(input);
        setValue(extractor.getValue());
    }

    public ValueExtractor<T> getExtractor() {
        return extractor;
    }

    @Override
    public void clear() {
        this.setValue(null);
    }
}
