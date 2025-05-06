package bg.tu_varna.sit.b1.f23621684.validators.logic;

import bg.tu_varna.sit.b1.f23621684.models.Date;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.LogicValidator;

public class AvailableHallValidator implements LogicValidator {

    private final int hallId;
    private final Date date;

    public AvailableHallValidator(int hallId, Date date) {
        this.hallId = hallId;
        this.date = date;
    }

    @Override
    public void validate() {

    }
}
