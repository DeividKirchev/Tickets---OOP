package bg.tu_varna.sit.b1.f23621684.data.dto;

import bg.tu_varna.sit.b1.f23621684.models.Event;
import bg.tu_varna.sit.b1.f23621684.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class EventDTO {
    private Event event;
    private List<Ticket> payedTickets;

    public EventDTO(Event event, List<Ticket> payedTickets) {
        this.event = event;
        this.payedTickets = new ArrayList<>(payedTickets);
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Ticket> getPayedTickets() {
        return new ArrayList<>(payedTickets);
    }

    public void setPayedTickets(List<Ticket> payedTickets) {
        this.payedTickets = payedTickets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(event.toString());
        sb.append(" | Bought tickets: ").append(payedTickets.size()).append("\n");
        return sb.toString();
    }
}
