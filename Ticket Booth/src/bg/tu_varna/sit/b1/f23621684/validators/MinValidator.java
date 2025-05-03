package bg.tu_varna.sit.b1.f23621684.validators;

public class MinValidator extends BaseValidator {
    private int minAmount;

    public MinValidator() {
        this.minAmount = minAmount;
    }

    @Override
    public boolean validate(String s) {
        if (!super.validate(s)) return false;
        try {
            int value = Integer.parseInt(s);
            return value >= minAmount;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
