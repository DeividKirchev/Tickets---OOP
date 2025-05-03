package bg.tu_varna.sit.b1.f23621684.validators;

public class IntegerValidator extends BaseValidator {
    private boolean isOptional;
    private String name;

    @Override
    public boolean validate(String s) {
        if (!super.validate(s)) return false;
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
