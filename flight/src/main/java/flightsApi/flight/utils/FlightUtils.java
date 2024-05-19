package flightsApi.flight.utils;

import flightsApi.flight.models.Dollar;
import flightsApi.flight.models.Flight;
import flightsApi.flight.models.dtos.FlightDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightUtils {

    public FlightDto convertFlightToDto(Flight flight, double dollarPrice) {
        return new FlightDto(flight.getFlightId(),flight.getOrigin(),
                flight.getDestiny(), flight.getCheckOut(),
                flight.getCheckIn(),flight.getPrice() * dollarPrice,
                flight.getFrecuency(),flight.getCompanyName());
    }

    public List<FlightDto> flightMapper(List<Flight> flights, double price) {
        return flights.stream()
                .map(flight -> new FlightDto(flight.getFlightId(),flight.getOrigin(),
                        flight.getDestiny(), flight.getCheckOut(),
                        flight.getCheckIn(), flight.getPrice() * price,
                        flight.getFrecuency(),flight.getCompanyName()))
                .collect(Collectors.toList());
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public Dollar fetchDollar() {
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta";
        return restTemplate.getForObject(apiUrl, Dollar.class);
    }

    public Dollar[] fetchAllDollars(){
        RestTemplate restTemplate = restTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares";
        return restTemplate.getForEntity(apiUrl,Dollar[].class).getBody();
    }

    public List<Flight> detectOffers(List<Flight> flights, int offerPrice) {
        return flights.stream()
                .filter(flight -> flight.getPrice() < offerPrice)
                .collect(Collectors.toList());
    }
}
