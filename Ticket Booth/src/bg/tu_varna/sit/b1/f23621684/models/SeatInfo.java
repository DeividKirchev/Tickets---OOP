package bg.tu_varna.sit.b1.f23621684.models;

import bg.tu_varna.sit.b1.f23621684.encoders.TicketEncoder;

import java.util.Objects;

public class SeatInfo {
    private Event event;
    private int row;
    private int seat;

    public SeatInfo(Event event, int row, int seat) {
        this.event = event;
        this.row = row;
        this.seat = seat;
    }

    public SeatInfo(SeatInfo si) {
        this.event = si.getEvent();
        this.row = si.getRow();
        this.seat = si.getSeat();
    }

    public SeatInfo(Event event, String code) {
        this(TicketEncoder.decode(code,event));
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SeatInfo seatInfo)) return false;
        return getRow() == seatInfo.getRow() && getSeat() == seatInfo.getSeat() && Objects.equals(getEvent(), seatInfo.getEvent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEvent(), getRow(), getSeat());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" | Event: ")
                .append(this.getEvent().getName())
                .append("\n | Date: ")
                .append(this.getEvent().getDate())
                .append("\n | Row: ")
                .append(this.getRow())
                .append("\n | Seat: ")
                .append(this.getSeat())
                .append("\n");
        return sb.toString();
    }
}
