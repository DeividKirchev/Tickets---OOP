package bg.tu_varna.sit.b1.f23621684.validators;


public class MaxValidator extends BaseValidator {
    private int maxAmount;

    public MaxValidator() {
        this.maxAmount = maxAmount;
    }

    @Override
    public boolean validate(String s) {
        if (!super.validate(s)) return false;
        try {
            int value = Integer.parseInt(s);
            return value <= maxAmount;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
