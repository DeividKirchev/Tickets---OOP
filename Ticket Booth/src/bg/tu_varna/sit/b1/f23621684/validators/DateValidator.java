package bg.tu_varna.sit.b1.f23621684.validators;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator extends BaseValidator {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    @Override
    public String validate(String s) {
        var parentValidate = super.validate(s);
        if (parentValidate != null) return parentValidate;
        try {
            LocalDate.parse(s, FORMATTER);
            return null;
        } catch (DateTimeParseException e) {
            return "Could not parse date. Invalid format.";
        }
    }
}
