package com.system.springboot.backend.repository;

import com.system.springboot.backend.entity.Warehouse;
import org.springframework.data.repository.CrudRepository;

public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {

    Warehouse findWarehouseByName(String name);
}
