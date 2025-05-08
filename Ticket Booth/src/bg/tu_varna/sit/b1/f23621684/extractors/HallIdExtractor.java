package bg.tu_varna.sit.b1.f23621684.extractors;

import bg.tu_varna.sit.b1.f23621684.data.HallList;
import bg.tu_varna.sit.b1.f23621684.exceptions.DataParsingException;
import bg.tu_varna.sit.b1.f23621684.models.Hall;

public class HallIdExtractor extends ValueExtractor<Hall> {
    @Override
    protected void parse(String input) {
        var extractor = new IntegerExtractor();
        extractor.extract(input);
        var value = extractor.getValue();

        var halls = HallList.getInstance().getList();
        var hall = halls.stream().filter(h -> h.getId() == value).findFirst();
        if (hall.isEmpty())
            throw new DataParsingException("No hall exists with id: " + value);
        setValue(hall.get());
    }
}
