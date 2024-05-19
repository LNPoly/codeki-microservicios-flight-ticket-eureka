package flightsApi.flight.services;

import flightsApi.flight.models.Company;
import flightsApi.flight.models.Dollar;
import flightsApi.flight.models.Flight;
import flightsApi.flight.models.dtos.FlightDto;
import flightsApi.flight.repositories.CompanyRepository;
import flightsApi.flight.repositories.FlightRepository;
import flightsApi.flight.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@Service
@RestController
public class FlightService {

    @Autowired
    public FlightRepository flightRepository;

    @Autowired
    public CompanyRepository companyRepository;

    @Autowired
    public FlightUtils flightUtils;

    public List<FlightDto> findAll(){
        double dollarPrice = getDollar();
        List<Flight> flights = flightRepository.findAll();
        return flightUtils.flightMapper(flights, dollarPrice);
    }

    public FlightDto searchFlightById(Long flightId)  {
        Flight flight1 = flightRepository.findById(flightId)
                .orElseThrow(null);
        double dollarPrice = getDollar();
        return flightUtils.convertFlightToDto(flight1, dollarPrice);
    }

    public Flight updateFlightById(Flight flight) {
        if (!flightRepository.existsById(flight.getFlightId())) {
            throw null;
        }
        Flight flightModified = new Flight();
        flightRepository.save(flightModified);
        return flightModified;
    }

    public void deleteFlightById(Long flightId) {
        flightRepository.deleteById(flightId);
    }

    public Flight createFlight(Flight flight, Long companyId) {
        Company company = companyRepository.findById(companyId).get(); //busco el id de company
        flight.setCompanyName(company);//ubico la compania en el vuelo
        return flightRepository.save(flight);

    }

    public double getDollar() {
        return flightUtils.fetchDollar().getPromedio();
    }

    public List<Dollar> getAllDollars(){
        return List.of(flightUtils.fetchAllDollars());
    }

    public List<Flight> getoffersPrice(int offerPrice) {
        List<Flight> flights = flightRepository.findAll();
        return flightUtils.detectOffers(flights, offerPrice);
    }

}
