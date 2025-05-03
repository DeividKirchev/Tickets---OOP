package bg.tu_varna.sit.b1.f23621684.validators;

public class IntegerValidator extends BaseValidator {
    private boolean isOptional;
    private String name;

    @Override
    public String validate(String s) {
        var parentValidate = super.validate(s);
        if (parentValidate != null) return parentValidate;
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return "Could not parse number.";
        }
        return null;
    }
}
