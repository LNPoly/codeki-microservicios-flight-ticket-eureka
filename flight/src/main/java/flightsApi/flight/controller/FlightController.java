package flightsApi.flight.controller;


import flightsApi.flight.models.Dollar;
import flightsApi.flight.models.Flight;

import flightsApi.flight.models.dtos.FlightDto;
import flightsApi.flight.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @CrossOrigin
    @GetMapping("") // trae toda la lista de vuelos.
    public List<FlightDto> getAllFlights(){
        return flightService.findAll();
    }
    @PostMapping("/create/{companyId}") // creador de vuelos
    public Flight createFlight(@RequestBody Flight flight,@PathVariable Long companyId){
        return flightService.createFlight(flight, companyId);
    }

    @GetMapping("/flights/{flightId}") // busca vuelos por id
    public FlightDto flightById(@PathVariable Long flightId) {
        return flightService.searchFlightById(flightId);
    }

    @PutMapping("/update/{flightId}") // para actualizar los datos de cada vuelo
    public Flight updateFlight(@RequestBody Flight flight){
        return flightService.updateFlightById(flight);
    }
    @DeleteMapping("/delete/{flightId}")//borrar vuelos por id
    public void deleteFlight(@PathVariable Long flightId){
        flightService.deleteFlightById(flightId);
    }
    //Endpoints individuales
    @GetMapping("/price")
    public List<Flight> flightPrice(){
        int offerPrice = 200;
        return flightService.getoffersPrice(offerPrice);
    }

    //Endpoints Dollar.java
    @GetMapping("/price-dollar")
    public double getDollar(){
        return flightService.getDollar();
    }

    @GetMapping("/allDollars")
    public List<Dollar> getAllDollars(){
        return flightService.getAllDollars();
    }

}
