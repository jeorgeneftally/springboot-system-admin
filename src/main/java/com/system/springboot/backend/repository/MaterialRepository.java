package com.system.springboot.backend.repository;

import com.system.springboot.backend.entity.Material;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MaterialRepository  extends CrudRepository<Material, Long> {

    List<Material> findMaterialsByNameContaining(String name);


}
