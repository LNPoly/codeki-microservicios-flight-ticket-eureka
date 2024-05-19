package flightsApi.flight.models.dtos;

import flightsApi.flight.models.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {

    private Long flightId;

    private String origin;

    private String destiny;

    private String checkOut;

    private String checkIn;

    private double convertedPrice;

    private String frecuency;

    public Company companyName;

}
