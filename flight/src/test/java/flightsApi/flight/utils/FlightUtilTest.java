package flightsApi.flight.utils;

import flightsApi.flight.models.Dollar;
import flightsApi.flight.models.Flight;
import flightsApi.flight.models.dtos.FlightDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FlightUtilTest {
    @Autowired
    FlightUtils flightUtils;

    @BeforeEach
    public void setUp(){

    }

    @Test
    void flightMapperTest(){
        double dollarPrice = 1015;
        List<Flight> flightList = new ArrayList<>();
        List<FlightDto> flightdtosList = new ArrayList<>();

        Flight flight = new Flight();
        flight.setFlightId(1L);
        flight.setOrigin("BA");
        flight.setDestiny("COR");
        flight.setCheckIn("SomeDate");
        flight.setCheckOut("AnoherDate");
        flight.setPrice(550);
        flight.setFrecuency("Weekly");

        flightList.add(flight);
        flightdtosList = flightUtils.flightMapper(flightList, dollarPrice);
        FlightDto flightdto = flightdtosList.get(0);

        assertEquals(1, flightdto.getFlightId());
        assertEquals(flight.getPrice() * dollarPrice, flightdto.getConvertedPrice());
    }

    @Test
    void detectOfferTest(){
        List<Flight> flightList = new ArrayList<>();
        flightList.add(new Flight("AEP","COL","09.00","12.00", 150.0,"SEMANAL"));
        flightList.add(new Flight("AEP","BRA","10.00","13.00", 200.0,"SEMANAL"));

        double offerPrice = 190.0;
        List<Flight> offers = flightUtils.detectOffers(flightList, (int) offerPrice);
        assertEquals(1,offers.size());
    }

    @Test
    void fetchDolarTest(){

        FlightUtils mockedFlightUtils =  mock(FlightUtils.class);
        Dollar dummyDollar = new Dollar();

        dummyDollar.setMoneda("USD");
        dummyDollar.setCasa("tarjeta");
        dummyDollar.setNombre("Tarjeta");
        dummyDollar.setCompra(1000);
        dummyDollar.setVenta(1200);

        when(mockedFlightUtils.fetchDollar()).thenReturn(dummyDollar);

        Dollar dolar = mockedFlightUtils.fetchDollar();
        assertEquals(1100, dolar.getPromedio());
        System.out.println("El promedio es: " + dolar.getPromedio());

    }
}
