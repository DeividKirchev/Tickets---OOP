package bg.tu_varna.sit.b1.f23621684.validators;

public class MinValidator extends BaseValidator {
    private int minAmount;

    public MinValidator(int minAmount) {
        this.minAmount = minAmount;
    }

    @Override
    public String validate(String s) {
        var parentValidate = super.validate(s);
        if (parentValidate != null) return parentValidate;
        try {
            int value = Integer.parseInt(s);
            if (value >= minAmount)
                return null;
            else return "Number must be more than " + minAmount;
        } catch (NumberFormatException e) {
            return "Invalid number format";
        }
    }

}
