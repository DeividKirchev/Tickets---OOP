package bg.tu_varna.sit.b1.f23621684.validators;


import bg.tu_varna.sit.b1.f23621684.models.Date;

public class DateValidator extends BaseValidator {

    @Override
    public String validate(String s) {
        var parentValidate = super.validate(s);
        if (parentValidate != null) return parentValidate;
        try {
            (new Date()).fromString(s);
            return null;
        } catch (IllegalArgumentException e) {
            return "Could not parse date. Invalid format.";
        }
    }
}
