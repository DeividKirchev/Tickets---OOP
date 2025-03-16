package bg.tu_varna.sit.b1.f23621684.models;

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
}
