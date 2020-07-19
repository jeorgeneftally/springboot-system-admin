package com.system.springboot.backend.repository;

import com.system.springboot.backend.entity.Firetruck;
import com.system.springboot.backend.entity.Maintenance;
import org.springframework.data.repository.CrudRepository;

public interface MaintenanceRepository  extends CrudRepository<Maintenance, Long> {

    Maintenance findTopByFiretruck(Firetruck firetruck);
}
