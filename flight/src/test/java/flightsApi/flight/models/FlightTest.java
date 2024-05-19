package flightsApi.flight.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FlightTest {

    private static Flight flight;

    @BeforeAll
    public static void setUp(){

        System.out.println("se esta creando un vuelo");
        flight = new Flight();
    }

    @Test
    public void setAndGetOriginTest(){ //probamos agregando un origen

        String testedOrigin = "AEP";
        flight.setOrigin("AEP");
        System.out.println("Se le asigna: " + testedOrigin);
        Assertions.assertEquals(flight.getOrigin(), testedOrigin);
    }

    @Test
    public void setAndGetDestinyTest(){ //probamos agregando un destino

        String testDestiny = "COR";
        flight.setDestiny("COR");
        System.out.println("Se le asigna: " + testDestiny);
        Assertions.assertEquals(flight.getDestiny(), testDestiny);
    }
}
