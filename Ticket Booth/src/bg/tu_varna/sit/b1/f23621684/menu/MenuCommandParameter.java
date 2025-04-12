package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.contracts.ICommandParameter;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.Validatable;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.Validator;

import java.util.ArrayList;
import java.util.List;

public class MenuCommandParameter implements ICommandParameter {

    private String name;
    private boolean optional;
    private List<Validator> validators;

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
    public void addValidator(Validator v) {
        this.validators.add(v);
    }

    @Override
    public boolean validate() {
        for (var v : getValidators())
            if (!v.validate()) return false;
        return true;
    }
}
