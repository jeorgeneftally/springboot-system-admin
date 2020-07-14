package com.system.springboot.backend.controller;

import com.system.springboot.backend.entity.User;
import com.system.springboot.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }
    /**
     *
     * @param telephone string unique for each user
     * @return list of type user
     */
    @GetMapping("telephone/{telephone}")
    public ResponseEntity<User> findByTelephone(@PathVariable String telephone){
        return new ResponseEntity <> (userService.findUserByTelephone(telephone), HttpStatus.OK);
    }
    /**
     *
     * @param name string containing the name
     * @return list of type user
     */
    @GetMapping("nameContaining/{name}")
    public ResponseEntity<List<User>> findByNameContaining(@PathVariable String name){
        return new ResponseEntity <> (userService.findUsersByNameAndSurnameContaining(name, name), HttpStatus.OK);
    }
    /**
     *
     * @param user
     * @return save object type type user, validate name and email
     */
    @PostMapping
    public ResponseEntity<User> saveUser(@Validated @RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }
    /**
     *
     * @param user new object type user
     * @param id of user require update
     * @return object update, validate name and email, exception of findById and save
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> saveUser(@Validated @RequestBody User user, @PathVariable Long id){
        User userNew = userService.findUserById(id);
        userNew = user;
        userNew.setId(id);
        return new ResponseEntity<>(userService.saveUser(userNew),HttpStatus.CREATED);
    }

}
