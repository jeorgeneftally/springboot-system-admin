package com.system.springboot.backend.controller;

import com.system.springboot.backend.entity.Compartment;
import com.system.springboot.backend.entity.CompartmentDetail;
import com.system.springboot.backend.service.CompartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/compartment")
public class CompartmentRestController {

    private final CompartmentService compartmentService;

    /**
     * endpoint findAll
     * @return a list objects of type compartment or exception
     */
    @GetMapping
    public ResponseEntity<List<Compartment>> findAllCompartment(){
        return new ResponseEntity <> (compartmentService.findAllCompartment(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Compartment> findCompartmentById(@PathVariable Long id){
        return new ResponseEntity<>(compartmentService.findCompartmentById(id), HttpStatus.OK);
    }


    /**
     *
     * @param compartment
     * @return
     */
    @PostMapping
    public ResponseEntity<Compartment> saveCompartment(@Validated @RequestBody Compartment compartment){
        return new ResponseEntity<>(compartmentService.saveCompartment(compartment),HttpStatus.CREATED);
    }

    /**
     *
     * @param compartment
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Compartment> UpdateCompartment(@Validated @RequestBody Compartment compartment, @PathVariable Long id){
        Compartment compartmentNew = compartmentService.findCompartmentById(id);
        compartmentNew= compartment;
        compartmentNew.setId(id);
        return new ResponseEntity<>(compartmentService.saveCompartment(compartmentNew),HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompartment(@PathVariable Long id){
        compartmentService.deleteCompartment(id);
        return new ResponseEntity<>("Compartment successfully deleted",HttpStatus.OK);
    }


    /**
     * endpoint findAll
     * @return a list objects of type compartmentDetail or exception
     */
    @GetMapping("/detail")
    public ResponseEntity<List<CompartmentDetail>> findAllCompartmentDetail(){
        return new ResponseEntity <> (compartmentService.findAllCompartmentDetail(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<CompartmentDetail> findCompartmentDetailById(@PathVariable Long id){
        return new ResponseEntity<>(compartmentService.findCompartmentDetailById(id), HttpStatus.OK);
    }


    /**
     *
     * @param compartmentDetail
     * @return
     */
    @PostMapping("/detail")
    public ResponseEntity<CompartmentDetail> saveCompartmentDetail(@Validated @RequestBody CompartmentDetail compartmentDetail){
        return new ResponseEntity<>(compartmentService.saveCompartmentDetail(compartmentDetail),HttpStatus.CREATED);
    }

    /**
     *
     * @param compartmentDetail
     * @param id
     * @return
     */
    @PutMapping("detail/{id}")
    public ResponseEntity<CompartmentDetail> UpdateCompartmentDetail(@Validated @RequestBody CompartmentDetail compartmentDetail, @PathVariable Long id){
        CompartmentDetail compartmentDetailNew = compartmentService.findCompartmentDetailById(id);
        compartmentDetailNew= compartmentDetail;
        compartmentDetailNew.setId(id);
        return new ResponseEntity<>(compartmentService.saveCompartmentDetail(compartmentDetailNew),HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("detail/{id}")
    public ResponseEntity<?> deleteCompartmentDetail(@PathVariable Long id){
        compartmentService.deleteCompartmentDetail(id);
        return new ResponseEntity<>("CompartmentDetail successfully deleted",HttpStatus.OK);
    }
}
