package com.system.springboot.backend.repository;

import com.system.springboot.backend.entity.Compartment;
import org.springframework.data.repository.CrudRepository;

public interface CompartmentRepository extends CrudRepository<Compartment, Long> {

    Compartment findCompartmentByName(String name);


}
