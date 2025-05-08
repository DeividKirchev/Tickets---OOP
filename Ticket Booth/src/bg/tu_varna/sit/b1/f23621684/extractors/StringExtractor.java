package bg.tu_varna.sit.b1.f23621684.extractors;

import bg.tu_varna.sit.b1.f23621684.exceptions.DataParsingException;

public class StringExtractor extends ValueExtractor<String> {
    @Override
    protected void parse(String input) {
        if (input.length() <= 2)
            throw new DataParsingException("Invalid string size");

        if (input.charAt(0) != '"' || input.charAt(input.length() - 1) != '"')
            throw new DataParsingException("Strings must be surrounded by \" characters");

        setValue(input.substring(1, input.length() - 1));
    }
}
