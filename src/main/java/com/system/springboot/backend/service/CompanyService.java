package com.system.springboot.backend.service;

import com.system.springboot.backend.entity.Company;
import com.system.springboot.backend.exception.InternalServerErrorException;
import com.system.springboot.backend.exception.NotFoundException;
import com.system.springboot.backend.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompanyService {
    /**
     *
     */
    private final CompanyRepository companyRepository;

    /**
     *
     * @return
     */
    public List<Company> findAllCompanies(){
        List<Company> listCompanies = new ArrayList<>();

        Optional.ofNullable(companyRepository.findAll())
                .orElseThrow(()-> new NotFoundException("empty list", new Exception("")))
                .forEach(listCompanies::add);
        return listCompanies;
    }

    /**
     *
     * @param id
     * @return
     */
    public Company findCompanyById(Long id){
        return companyRepository.findById(id).orElseThrow(()-> new NotFoundException("company not exist",new Exception("")));
    }

    /**
     *
     * @param company
     * @return
     */
    public Company saveCompany(Company company){
        return Optional.of(companyRepository.save(company))
                .orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
    }

    /**
     *
     * @param id
     */
    public void deleteCompany(Long id){
        Company company=findCompanyById(id);
        companyRepository.delete(company);
    }
}
