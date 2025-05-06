package bg.tu_varna.sit.b1.f23621684.validators.input;

import bg.tu_varna.sit.b1.f23621684.data.reporters.HallDataReporter;

public class HallIdInputValidator extends IntegerInputValidator {
    @Override
    public String validate(String s) {
        var parentValidate = super.validate(s);
        if (parentValidate != null) return parentValidate;

        int value = getParsedValue();

        var hall = HallDataReporter.getById(value);
        if (hall == null)
            return "Invalid Hall ID.";
        return null;

    }
}
