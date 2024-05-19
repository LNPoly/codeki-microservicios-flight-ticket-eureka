package flightsApi.flight.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "company")
public class Company{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long companyId;
    public String name;
    public String page;
    public String banner;

    public Company(String name, String page, String banner) {
        this.name = name;
        this.page = page;
        this.banner = banner;
    }
}
