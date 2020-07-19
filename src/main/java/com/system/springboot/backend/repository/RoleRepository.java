package com.system.springboot.backend.repository;

import com.system.springboot.backend.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository  extends CrudRepository<Role, Long> {
}
