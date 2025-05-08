package bg.tu_varna.sit.b1.f23621684.parameters;

import bg.tu_varna.sit.b1.f23621684.contracts.Value;
import bg.tu_varna.sit.b1.f23621684.extractors.StringExtractor;

public class StringParameter extends ValueParameter<String>{

    public StringParameter(String name, boolean optional) {
        super(name, optional, new StringExtractor());
    }

}
