package bg.tu_varna.sit.b1.f23621684.models;

import bg.tu_varna.sit.b1.f23621684.encoders.TicketEncoder;

import java.util.Objects;

public class Ticket {
    private String note;
    private boolean isPayed;
    private final SeatInfo seatInfo;

    public Ticket(String note, boolean isPayed, SeatInfo seatInfo) {
        this.note = note;
        this.isPayed = isPayed;
        this.seatInfo = new SeatInfo(seatInfo.getEvent(), seatInfo.getRow(), seatInfo.getSeat());
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public String generateCode() {
        if (!this.isPayed()) return null;
        return TicketEncoder.encode(this.seatInfo);
    }

    public SeatInfo getSeatInfo() {
        return this.seatInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(getSeatInfo(), ticket.getSeatInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSeatInfo());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getSeatInfo().toString())
                .append(" | Note: ")
                .append(this.getNote())
                .append("\n");

        return sb.toString();
    }
}
