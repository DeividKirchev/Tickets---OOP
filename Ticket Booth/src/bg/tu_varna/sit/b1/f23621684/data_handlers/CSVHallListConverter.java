package bg.tu_varna.sit.b1.f23621684.data_handlers;

import bg.tu_varna.sit.b1.f23621684.data_handlers.contracts.DataFormatConverter;
import bg.tu_varna.sit.b1.f23621684.exceptions.DataFormatException;
import bg.tu_varna.sit.b1.f23621684.models.Hall;

import java.util.ArrayList;
import java.util.List;

public class CSVHallListConverter implements DataFormatConverter<List<Hall>, String> {

    @Override
    public List<Hall> load(String data) {
        List<Hall> list = new ArrayList<>();
        String[] lines = data.split("\n");
        int lineNumber = 0;
        for (String line : lines) {
            lineNumber++;
            line = line.trim();
            if (line.isEmpty()) continue;
            String[] tokens = line.split(",");
            if (tokens.length != 3)
                throw new DataFormatException("Invalid format at line " + lineNumber + ": " + line);

            try {
                int id = Integer.parseInt(tokens[0].trim());
                int rows = Integer.parseInt(tokens[1].trim());
                int seatsPerRow = Integer.parseInt(tokens[2].trim());
                Hall hall = new Hall(id, rows, seatsPerRow);
                list.add(hall);
            } catch (NumberFormatException e) {
                throw new DataFormatException("Invalid format at line " + lineNumber + ": " + line);
            }
        }
        return list;
    }


    @Override
    public String save(List<Hall> data) {
        StringBuilder sb = new StringBuilder();
        for (Hall hall : data) {
            sb.append(hall.getId())
                    .append(",")
                    .append(hall.getRows())
                    .append(",")
                    .append(hall.getSeatsPerRow())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}

