package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.validators.contracts.ValidatableParameter;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.Validator;

import java.util.ArrayList;
import java.util.List;

public class MenuCommandParameter extends BaseCommandParameter implements ValidatableParameter {
    private final List<Validator> validators;

    public MenuCommandParameter(String name, boolean optional) {
        super(name, optional);
        validators = new ArrayList<>();
    }

    @Override
    public MenuCommandParameter addValidator(Validator v) {
        this.validators.add(v);
        return this;
    }

    @Override
    public String validate(String s) {
        for (var v : validators)
        {
            var validation = v.validate(s);
            if (validation != null) return validation;
        }
        return null;
    }
}
