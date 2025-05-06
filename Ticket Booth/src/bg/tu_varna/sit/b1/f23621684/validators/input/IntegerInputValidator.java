package bg.tu_varna.sit.b1.f23621684.validators.input;

public class IntegerInputValidator extends BaseInputValidator {
    private int parsedValue;

    public int getParsedValue() {
        return parsedValue;
    }

    public void setParsedValue(int parsedValue) {
        this.parsedValue = parsedValue;
    }

    @Override
    public String validate(String s) {
        var parentValidate = super.validate(s);
        if (parentValidate != null) return parentValidate;
        try {
            setParsedValue(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return "Could not parse number.";
        }
        return null;
    }
}
