package flightsApi.flight.services;

import flightsApi.flight.models.Company;
import flightsApi.flight.models.dtos.CompanyDto;
import flightsApi.flight.repositories.CompanyRepository;
import flightsApi.flight.utils.CompanyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
@RestController
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    
    @Autowired
    CompanyUtils companyUtils;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public CompanyDto getCompanyById(Long companyId)  {
        Company company1 = companyRepository.findById(companyId)
                .orElseThrow(null);
        return companyUtils.convertCompanyToDto(company1);
    }

    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    public Optional<Company> updateCompanyById(Company company) {
        companyRepository.save(company);
        return Optional.of(companyRepository.findById(company.getCompanyId()).get());
    }

    public void deleteCompanyById(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
