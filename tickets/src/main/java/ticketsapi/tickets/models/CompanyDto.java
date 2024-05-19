package ticketsapi.tickets.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDto {

    private Long companyId;
    private String name;
    private String page;
    private String banner;
}
