package bg.tu_varna.sit.b1.f23621684.models;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private Hall hall;
    private String name;
    private Date date;
    private List<Ticket> tickets;

    public Event(Hall hall, String name, Date date) {
        this.hall = hall;
        this.name = name;
        this.date = date;
        tickets = new ArrayList<Ticket>();
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
        this.tickets.add(t);
    }
}
