package com.system.springboot.backend.repository;

import com.system.springboot.backend.entity.Company;
import com.system.springboot.backend.entity.Firetruck;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FiretruckRepository extends CrudRepository<Firetruck, Long> {

    List<Firetruck> findFiretruckByStateOrderByCreationDesc(String state);

    List<Firetruck> findFiretruckByCompany(Company company);

}
