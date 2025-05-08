package bg.tu_varna.sit.b1.f23621684.extractors;

import bg.tu_varna.sit.b1.f23621684.exceptions.DataParsingException;
import bg.tu_varna.sit.b1.f23621684.models.Date;

public class DateExtractor extends ValueExtractor<Date> {
    @Override
    protected void parse(String input) {
        try {
            var date = new Date();
            date.fromString(input);
            setValue(date);
        } catch (IllegalArgumentException e) {
            throw new DataParsingException("Invalid date format");
        }
    }
}
