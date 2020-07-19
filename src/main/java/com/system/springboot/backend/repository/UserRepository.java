package com.system.springboot.backend.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.system.springboot.backend.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByTelephone(String telephone);

    List <User> findUsersByNameContainingOrSurnameContaining(String name,String Surname);


}
