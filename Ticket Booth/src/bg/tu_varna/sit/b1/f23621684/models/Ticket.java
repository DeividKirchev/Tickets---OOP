package bg.tu_varna.sit.b1.f23621684.models;

public class Ticket {
    private int note;
    private String code;
    private boolean isPayed;

    public Ticket(int note, boolean isPayed) {
        this.note = note;
        this.isPayed = isPayed;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCode() {
        return code;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public void generateCode(String hash) {
        // TODO: Generate code with row, seat, and hash
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
