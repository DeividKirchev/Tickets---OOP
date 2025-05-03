package bg.tu_varna.sit.b1.f23621684.validators;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator extends BaseValidator {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    @Override
    public boolean validate(String s) {
        if (!super.validate(s)) return false;
        try {
            LocalDate.parse(s, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
