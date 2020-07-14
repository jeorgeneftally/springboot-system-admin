package com.system.springboot.backend.controller;

import com.system.springboot.backend.entity.User;
import com.system.springboot.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserRestController {

    /**
     * Injection of service user by constructor
     */
    private final UserService userService;

    /**
     * endpoint findAll
     * @return a list objects of type user or exception
     */
    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity <> (userService.findAllUsers(), HttpStatus.OK);
    }
    /**
     *
     * @param id number unique for each user
     * @return a object type user
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    /**
     *
     * @param telephone string unique for each user
     * @return list of type user
     */
    @GetMapping("telephone/{telephone}")
    public ResponseEntity<User> findByTelephone(@PathVariable String telephone){
        return new ResponseEntity <> (userService.findByTelephone(telephone), HttpStatus.OK);
    }

    /**
     *
     * @param name string containing the name
     * @return list of type user
     */
    @GetMapping("nameContaining/{name}")
    public ResponseEntity<List<User>> findByNameContaining(@PathVariable String name){
        return new ResponseEntity <> (userService.findByNameContaining(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@Validated @RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }


}
