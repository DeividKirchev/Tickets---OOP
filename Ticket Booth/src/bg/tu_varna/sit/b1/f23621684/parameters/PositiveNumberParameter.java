package bg.tu_varna.sit.b1.f23621684.parameters;

import bg.tu_varna.sit.b1.f23621684.extractors.PositiveNumberExtractor;

public class PositiveNumberParameter extends ValueParameter<Integer> {

    public PositiveNumberParameter(String name, boolean optional) {
        super(name, optional, new PositiveNumberExtractor());
    }

}
