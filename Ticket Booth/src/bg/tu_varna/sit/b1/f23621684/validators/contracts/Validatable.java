package bg.tu_varna.sit.b1.f23621684.validators.contracts;

import java.util.List;

public interface Validatable extends Validator {
    void addValidator(Validator v);
}
