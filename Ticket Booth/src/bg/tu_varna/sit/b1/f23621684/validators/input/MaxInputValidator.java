package bg.tu_varna.sit.b1.f23621684.validators.input;


public class MaxInputValidator extends IntegerInputValidator {
    private int maxAmount;

    public MaxInputValidator(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public String validate(String s) {
        var parentValidate = super.validate(s);
        if (parentValidate != null) return parentValidate;

        int value = getParsedValue();
        if (value <= maxAmount)
            return null;
        else
            return "Number must be less than " + maxAmount;
    }

}
