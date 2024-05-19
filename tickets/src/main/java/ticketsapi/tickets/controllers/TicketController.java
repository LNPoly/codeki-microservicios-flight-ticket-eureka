package ticketsapi.tickets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ticketsapi.tickets.models.CompanyDto;
import ticketsapi.tickets.models.FlightDto;
import ticketsapi.tickets.models.Ticket;
import ticketsapi.tickets.services.FlightClient;
import ticketsapi.tickets.services.TicketService;

import java.util.List;

@Controller
@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    FlightClient flightClient;

    @GetMapping("/allTickets")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @PostMapping("/create/flights/{flightId}")
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketService.createTickets(ticket);
    }

    @GetMapping("/getTicket/{ticketId}")
    public Ticket getTicketById(@PathVariable Long ticketId){
        return ticketService.getTicketById(ticketId);
    }

    @GetMapping("/flights") // Todos los vuelos
    public List<FlightDto> getAllFlights(){
        return flightClient.getAllFlights();
    }

    @GetMapping("/flights/{flightId}") // vuelos por id
    public FlightDto flightById(@PathVariable Long flightId){
        return flightClient.flightById(flightId);
    }

    @DeleteMapping("/deleteTicket/{ticketId}")
    public void deleteTicket(@PathVariable Long ticketId){
        ticketService.deleteTicket(ticketId);
    }

    @PutMapping("/updateTicket/{ticketId}")
    public Ticket updateTicket(@PathVariable Long ticketId){
        return ticketService.updateTicketById(ticketId);
    }
}
