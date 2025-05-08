package bg.tu_varna.sit.b1.f23621684.parameters;

import bg.tu_varna.sit.b1.f23621684.contracts.CommandParameter;
import bg.tu_varna.sit.b1.f23621684.extractors.contracts.Extractor;

public abstract class BaseCommandParameter implements CommandParameter, Extractor {
    private final String name;
    private final boolean optional;

    public BaseCommandParameter(String name, boolean optional) {
        this.name = name;
        this.optional = optional;
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

}
