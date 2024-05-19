package ticketsapi.tickets.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightDto {

    private Long flightId;
    private String origin;
    private String destiny;
    private String checkOut;
    private String checkIn;
    private double convertedPrice;
    private String frecuency;
    private CompanyDto companyName;

}
