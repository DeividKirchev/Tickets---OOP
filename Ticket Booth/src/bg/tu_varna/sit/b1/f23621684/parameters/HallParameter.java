package bg.tu_varna.sit.b1.f23621684.parameters;

import bg.tu_varna.sit.b1.f23621684.extractors.HallIdExtractor;
import bg.tu_varna.sit.b1.f23621684.models.Hall;

public class HallParameter extends ValueParameter<Hall> {

    public HallParameter(String name, boolean optional) {
        super(name, optional, new HallIdExtractor());
    }

}