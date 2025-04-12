package bg.tu_varna.sit.b1.f23621684.contracts;

import bg.tu_varna.sit.b1.f23621684.validators.contracts.Validatable;

public interface ICommandParameter extends Validatable {
    String getName();
    boolean isOptional();

}

