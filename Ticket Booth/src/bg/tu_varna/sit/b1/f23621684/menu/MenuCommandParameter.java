package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.validators.contracts.ValidatableParameter;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.Validator;

import java.util.ArrayList;
import java.util.List;

public class MenuCommandParameter implements ValidatableParameter {

    private final String name;
    private final boolean optional;
    private final List<Validator> validators;

    public MenuCommandParameter(String name, boolean optional) {
        this.name = name;
        this.optional = optional;
        validators = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isOptional() {
        return this.optional;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getName());
        sb.append(">");
        if (isOptional()) {
            sb.append("]");
            sb.insert(0, "[");
        }
        return sb.toString();
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
