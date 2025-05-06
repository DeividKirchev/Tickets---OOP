package bg.tu_varna.sit.b1.f23621684.models;

import java.util.Objects;

public class Hall {
    private int id;
    private int rows;
    private int seatsPerRow;

    public Hall(int id, int rows, int seatsPerRow) {
        this.id = id;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Hall hall)) return false;
        return getId() == hall.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    public int getSeatsCount() {
        return getSeatsPerRow() * getRows();
    }
}
