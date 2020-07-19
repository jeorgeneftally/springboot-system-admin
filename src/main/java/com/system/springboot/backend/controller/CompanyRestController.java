package com.system.springboot.backend.controller;

import com.system.springboot.backend.entity.Company;
import com.system.springboot.backend.entity.Course;
import com.system.springboot.backend.service.CompanyService;
import com.system.springboot.backend.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyRestController {

    /**
     * Injection of service user by constructor
     */
    private final CompanyService companyService;
    /**
     * endpoint findAll
     * @return a list objects of type course or exception
     */
    @GetMapping
    public ResponseEntity<List<Company>> findAllCompanies(){
        return new ResponseEntity <> (companyService.findAllCompanies(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable Long id){
        return new ResponseEntity<>(companyService.findCompanyById(id), HttpStatus.OK);
    }


    /**
     *
     * @param company
     * @return
     */
    @PostMapping
    public ResponseEntity<Company> saveCompany(@Validated @RequestBody Company company){
        return new ResponseEntity<>(companyService.saveCompany(company),HttpStatus.CREATED);
    }

    /**
     *
     * @param company
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Company> UpdateCourse(@Validated @RequestBody Company company, @PathVariable Long id){
        Company companyNew = companyService.findCompanyById(id);
        companyNew = company;
        companyNew.setId(id);
        return new ResponseEntity<>(companyService.saveCompany(companyNew),HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompanyNew(@PathVariable Long id){
        companyService.deleteCompany(id);
        return new ResponseEntity<>("Company successfully deleted",HttpStatus.OK);
    }

}
