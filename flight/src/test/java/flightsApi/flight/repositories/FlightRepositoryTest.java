package flightsApi.flight.repositories;

import flightsApi.flight.models.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;
    private Flight flight;

    @BeforeEach
        //se ejecuta, antes de la ejecucion de cada metodo.
    void flightSetup(){
        // se crea el objeto
        flight = new Flight("COR","EZE","8.00","11.00",200,"DIARIA");
    }
    @Test
    void saveFlightTest(){
        // Se guarda el vuelo creado del metodo flightSetup
        Flight flightBD = flightRepository.save(flight);

        assertThat(flightBD).isNotNull();
        assertThat(flightBD.getId()).isGreaterThan(0);
    }
    @Test
    void flightFindByIdTest() {
        flightRepository.save(flight);
        Flight flightDB = flightRepository.findById(flight.getId()).get();
        assertThat(flightDB).isNotNull();
    }

    @Test
    void findAllFlightTest(){
        Flight flight1 = new Flight("BRA","EZE","8.00","11.00",200,"MENSUAL");

        flightRepository.save(flight); // Se trajo el vuelo guardado del metodo saveFlightTest
        flightRepository.save(flight1); //se guarda otro vuelo

        List<Flight> flightList = flightRepository.findAll();

        assertThat(flightList).isNotNull();
        assertThat(flightList.size()).isEqualTo(2); //Compara los vuelos que hay en la lista con el resultado esperado
    }
    @Test
    void flightdeleteByIdTest(){
        flightRepository.save(flight);

        flightRepository.deleteById(flight.getId());
        Optional<Flight> deleteFlight = flightRepository.findById(flight.getId());
        assertThat(deleteFlight).isEmpty();
    }

    @Test
    void flightUpdateTest(){
        flightRepository.save(flight);
        Flight flightDB = flightRepository.findById(flight.getId()).get();

        flightDB.setOrigin("BRA");
        flightDB.setDestiny("COR");

        Flight flightUpdated = flightRepository.save(flightDB);

        assertThat(flightUpdated.getOrigin()).isEqualTo("BRA");
        assertThat(flightUpdated.getDestiny()).isEqualTo("COR");
    }

}
