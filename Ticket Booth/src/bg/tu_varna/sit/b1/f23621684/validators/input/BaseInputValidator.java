package bg.tu_varna.sit.b1.f23621684.validators.input;

import bg.tu_varna.sit.b1.f23621684.validators.contracts.InputValidator;

public abstract class BaseInputValidator implements InputValidator {
    public BaseInputValidator() {
    }

    @Override
    public String validate(String s) {
        return s != null ? null : "Missing value.";
    }
}
