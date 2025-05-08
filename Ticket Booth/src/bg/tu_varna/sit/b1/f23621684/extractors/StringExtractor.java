package bg.tu_varna.sit.b1.f23621684.extractors;

import bg.tu_varna.sit.b1.f23621684.exceptions.DataParsingException;

public class StringExtractor extends ValueExtractor<String> {
    @Override
    protected void parse(String input) {
        if (input.isEmpty())
            throw new DataParsingException("String is empty");

        setValue(input);
    }
}
