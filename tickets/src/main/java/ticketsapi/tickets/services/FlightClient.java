package ticketsapi.tickets.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ticketsapi.tickets.models.FlightDto;

import java.util.List;

@FeignClient(name = "flight-api")
public interface FlightClient {

    @GetMapping("/flights") //trae todos los vuelos con la compania enlazada
    List<FlightDto> getAllFlights();

    @GetMapping("/flights/{flightId}")
    FlightDto flightById(@PathVariable Long flightId);

}
