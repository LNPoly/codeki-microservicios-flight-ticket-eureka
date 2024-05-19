package flightsApi.flight.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private Long companyId;
    
    private String name;
    
    private String page;
    
    private String banner;

}
