package bg.tu_varna.sit.b1.f23621684.validators;


public class MaxValidator extends BaseValidator {
    private int maxAmount;

    public MaxValidator(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public String validate(String s) {
        var parentValidate = super.validate(s);
        if (parentValidate != null) return parentValidate;
        try {
            int value = Integer.parseInt(s);
            if (value <= maxAmount)
                return null;
            else return "Number must be less than " + maxAmount;
        } catch (NumberFormatException e) {
            return "Invalid number format";
        }
    }

}
