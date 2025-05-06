package bg.tu_varna.sit.b1.f23621684.validators.input;


import bg.tu_varna.sit.b1.f23621684.models.Date;

public class DateInputValidator extends BaseInputValidator {

    @Override
    public String validate(String s) {
        var parentValidate = super.validate(s);
        if (parentValidate != null) return parentValidate;
        try {
            (new Date()).fromString(s);
        } catch (IllegalArgumentException e) {
            return "Could not parse date. Invalid format.";
        }
        return null;
    }
}
