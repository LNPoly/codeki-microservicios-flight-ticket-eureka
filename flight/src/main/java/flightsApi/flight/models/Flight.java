package flightsApi.flight.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long flightId;

    public String origin;

    public String destiny;

    public String checkOut;

    public String checkIn;

    public double price;

    public String frecuency;

    @ManyToOne
    @JoinColumn(name = "companyId")
    public Company companyName;

    public Flight(String origin, String destiny, String checkOut, String checkIn, double price, String frecuency) {
        this.origin = origin;
        this.destiny = destiny;
        this.checkOut = checkOut;
        this.checkIn = checkIn;
        this.price = price;
        this.frecuency = frecuency;
    }
}
