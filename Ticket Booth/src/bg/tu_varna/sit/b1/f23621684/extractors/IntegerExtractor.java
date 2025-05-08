package bg.tu_varna.sit.b1.f23621684.extractors;

import bg.tu_varna.sit.b1.f23621684.exceptions.DataParsingException;

public class IntegerExtractor extends ValueExtractor<Integer> {
    @Override
    protected void parse(String input) {
        try {
            setValue(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new DataParsingException("Could not parse number.");
        }
    }
}
