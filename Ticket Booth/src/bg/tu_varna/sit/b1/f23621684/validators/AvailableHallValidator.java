package bg.tu_varna.sit.b1.f23621684.validators;

import bg.tu_varna.sit.b1.f23621684.models.Date;
import bg.tu_varna.sit.b1.f23621684.models.Hall;
import bg.tu_varna.sit.b1.f23621684.validators.contracts.Validator;

public class AvailableHallValidator implements Validator {

    private final Hall hall;
    private final Date date;

    public AvailableHallValidator(Hall hall, Date date) {
        this.hall = hall;
        this.date = date;
    }

    @Override
    public boolean validate() {
        // TODO: Implement validation
        return true;
    }
}
