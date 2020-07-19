package com.system.springboot.backend.repository;

import com.system.springboot.backend.entity.UserDetail;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailRepository extends CrudRepository<UserDetail, Long> {
}
