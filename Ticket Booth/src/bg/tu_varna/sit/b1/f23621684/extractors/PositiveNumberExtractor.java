package bg.tu_varna.sit.b1.f23621684.extractors;

import bg.tu_varna.sit.b1.f23621684.exceptions.DataParsingException;

public class PositiveNumberExtractor extends ValueExtractor<Integer> {
    @Override
    protected void parse(String input) {

        var extractor = new IntegerExtractor();
        extractor.extract(input);
        var value = extractor.getValue();
        if (value <= 0)
            throw new DataParsingException("Number must be positive");
        setValue(value);
    }
}
