package bg.tu_varna.sit.b1.f23621684.validators;

import bg.tu_varna.sit.b1.f23621684.contracts.ICommandParameter;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.Validator;

import java.util.List;

public class CommandParameterValidator implements Validator {
    private List<ICommandParameter> params;
    private List<String> input;

    public CommandParameterValidator(List<ICommandParameter> params, List<String> input) {
        this.input = input;
        this.params = params;
    }

    @Override
    public boolean validate() {
        for(var p : params)
            if(p.validate())
                return false;
        return true;
    }
}
