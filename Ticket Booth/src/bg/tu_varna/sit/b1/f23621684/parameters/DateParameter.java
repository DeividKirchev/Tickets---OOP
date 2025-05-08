package bg.tu_varna.sit.b1.f23621684.parameters;

import bg.tu_varna.sit.b1.f23621684.extractors.DateExtractor;
import bg.tu_varna.sit.b1.f23621684.models.Date;

public class DateParameter extends ValueParameter<Date> {

    public DateParameter(String name, boolean optional) {
        super(name, optional, new DateExtractor());
    }
}
