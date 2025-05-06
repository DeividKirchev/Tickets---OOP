package bg.tu_varna.sit.b1.f23621684.validators.contracts;

import bg.tu_varna.sit.b1.f23621684.contracts.CommandParameter;
import bg.tu_varna.sit.b1.f23621684.menu.MenuCommandParameter;

public interface ValidatableParameter extends CommandParameter, InputValidator {
    MenuCommandParameter addValidator(InputValidator v);
}
