package ticketsapi.tickets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ticketsapi.tickets.models.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TicketService {

    @Autowired
    FlightClient flightClient;

    private final List<Ticket> tickets = new ArrayList<>();

    public Ticket createTickets(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }

    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public Ticket getTicketById(Long ticketId) {
        return tickets.stream()
                .filter(ticket -> ticket.getTicketId().equals(ticketId))
                .findFirst()
                .orElse(null);
    }

    public void deleteTicket(Long ticketId) {
        tickets.stream()
                .filter(ticket -> ticket.getTicketId().equals(ticketId))
                .findFirst()
                .ifPresent(tickets::remove);
    }

    public Ticket updateTicketById(Long ticketId) {
        return tickets.stream()
                .filter(ticket -> ticket.getTicketId().equals(ticketId))
                .findFirst()
                .orElse(null);
    }
}