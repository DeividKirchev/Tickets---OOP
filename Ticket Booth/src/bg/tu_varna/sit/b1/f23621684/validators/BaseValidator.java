package bg.tu_varna.sit.b1.f23621684.validators;

import bg.tu_varna.sit.b1.f23621684.validators.contracts.Validator;

public abstract class BaseValidator implements Validator {
    public BaseValidator() {
    }

    @Override
    public String validate(String s) {
        return s != null ? null : "Missing value.";
    }
}
