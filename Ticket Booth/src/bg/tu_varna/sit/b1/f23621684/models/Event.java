package bg.tu_varna.sit.b1.f23621684.models;

import bg.tu_varna.sit.b1.f23621684.data.reporters.TicketReporter;
import bg.tu_varna.sit.b1.f23621684.exceptions.InvalidSeatException;
import bg.tu_varna.sit.b1.f23621684.exceptions.SeatAlreadyBooked;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Event {
    private Hall hall;
    private String name;
    private Date date;
    private List<Ticket> tickets;

    public Event(Hall hall, String name, Date date) {
        this.hall = hall;
        this.name = name;
        this.date = date;
        tickets = new ArrayList<>();
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket t) {
        var ticket = TicketReporter.getTicket(this, t.getSeatInfo().getRow(), t.getSeatInfo().getSeat());
        if (ticket != null)
            throw new SeatAlreadyBooked("Seat is already booked");

        var hall = this.getHall();
        if (hall.getRows() < t.getSeatInfo().getRow())
            throw new InvalidSeatException("Hall does not have row " + t.getSeatInfo().getRow());

        if (hall.getSeatsPerRow() < t.getSeatInfo().getSeat())
            throw new InvalidSeatException("Hall does not have seat " + t.getSeatInfo().getSeat());

        this.tickets.add(t);
    }

    public void removeTicket(Ticket t) {
        this.tickets.remove(t);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Event event)) return false;
        return Objects.equals(getHall(), event.getHall()) && Objects.equals(getName(), event.getName()) && Objects.equals(getDate(), event.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHall(), getName(), getDate());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" | Event: ")
                .append(getName())
                .append("\n | Date: ")
                .append(getDate())
                .append("\n | Hall: ")
                .append(getHall().getId())
                .append("\n | Booked/Payed tickets: ")
                .append(getTickets().size())
                .append("\n");
        return sb.toString();
    }
}
