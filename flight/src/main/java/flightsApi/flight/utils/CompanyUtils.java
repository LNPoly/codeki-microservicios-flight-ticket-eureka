package flightsApi.flight.utils;

import flightsApi.flight.models.Company;
import flightsApi.flight.models.dtos.CompanyDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyUtils {

    public CompanyDto convertCompanyToDto(Company company1) {
        return new CompanyDto(company1.getCompanyId(),
                company1.getName(),
                company1.getPage(),
                company1.getBanner());
    }
}
