package com.system.springboot.backend.controller;

import com.system.springboot.backend.entity.User;
import com.system.springboot.backend.service.UploadsService;
import com.system.springboot.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserRestController {

    /**
     * Injection of service user by constructor
     */
    private final UserService userService;
    private final UploadsService uploadsService;
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
    public ResponseEntity<User> findUserById(@PathVariable Long id){
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
    @GetMapping("containingNameSurname/{name}")
    public ResponseEntity<List<User>> findUsersByNameAndSurnameContaining(@PathVariable String name){
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
    public ResponseEntity<User> updateUser(@Validated @RequestBody User user, @PathVariable Long id){
        User userNew = userService.findUserById(id);
        userNew = user;
        userNew.setId(id);
        return new ResponseEntity<>(userService.saveUser(userNew),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User successfully deleted",HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,@RequestParam("id") Long id) throws IOException {
        String route = "users";
        User user = userService.findUserById(id);

        if (!file.isEmpty()) {

            String nameFile = null;
            nameFile = uploadsService.copy(file, route);
            String namePhotoOld = user.getImage();
            uploadsService.delete(namePhotoOld, route);
            user.setImage(nameFile);
            userService.saveUser(user);


        }
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/uploads/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
        String route="users";
        Resource recurso = null;

        try {
            recurso = uploadsService.load(nombreFoto,route);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

        return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
    }

}
