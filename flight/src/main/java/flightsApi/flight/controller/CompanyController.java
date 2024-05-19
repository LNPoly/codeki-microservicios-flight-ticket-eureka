package flightsApi.flight.controller;

import flightsApi.flight.models.Company;
import flightsApi.flight.models.dtos.CompanyDto;
import flightsApi.flight.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/allCompanies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/{companyId}")
    public CompanyDto getCompanyById(@PathVariable Long companyId) {
        return companyService.getCompanyById(companyId);
    }

    @PostMapping("/create")
    public void createOneCompany(@RequestBody Company company){
        companyService.createCompany(company);
    }

    @PutMapping("/update/{companyId}")
    public Optional<Company> updateCompany(@RequestBody Company company){
        return companyService.updateCompanyById(company);
    }

    @DeleteMapping("/delete/{companyId}")
    public void deleteCompanyById(@PathVariable Long companyId){
        companyService.deleteCompanyById(companyId);
    }
}
