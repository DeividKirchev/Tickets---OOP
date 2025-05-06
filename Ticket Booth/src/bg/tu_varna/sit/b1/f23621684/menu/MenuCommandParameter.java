package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.validators.contracts.ValidatableParameter;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class MenuCommandParameter extends BaseCommandParameter implements ValidatableParameter {
    private final List<InputValidator> inputValidators;

    public MenuCommandParameter(String name, boolean optional) {
        super(name, optional);
        inputValidators = new ArrayList<>();
    }

    @Override
    public MenuCommandParameter addValidator(InputValidator v) {
        this.inputValidators.add(v);
        return this;
    }

    @Override
    public String validate(String s) {
        for (var v : inputValidators)
        {
            var validation = v.validate(s);
            if (validation != null) return validation;
        }
        return null;
    }
}
