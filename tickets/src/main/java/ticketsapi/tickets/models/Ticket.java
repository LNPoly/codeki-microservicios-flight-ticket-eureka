package ticketsapi.tickets.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    private Long ticketId;

    private String date;

    private String passengerName;

    private String passengerEmail;

    private FlightDto flight;

    public Ticket(Long ticketId, String date, String passengerName, String passengerEmail) {
        this.ticketId = ticketId;
        this.date = date;
        this.passengerName = passengerName;
        this.passengerEmail = passengerEmail;

    }

}
