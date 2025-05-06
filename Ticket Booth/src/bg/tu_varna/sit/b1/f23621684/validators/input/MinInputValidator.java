package bg.tu_varna.sit.b1.f23621684.validators.input;

public class MinInputValidator extends IntegerInputValidator {
    private int minAmount;

    public MinInputValidator(int minAmount) {
        this.minAmount = minAmount;
    }

    @Override
    public String validate(String s) {
        var parentValidate = super.validate(s);
        if (parentValidate != null) return parentValidate;

        int value = getParsedValue();
        if (value >= minAmount)
            return null;
        else
            return "Number must be more than " + minAmount;
    }

}
