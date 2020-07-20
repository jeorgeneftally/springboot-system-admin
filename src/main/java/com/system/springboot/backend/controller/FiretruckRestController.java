package com.system.springboot.backend.controller;

import com.system.springboot.backend.entity.Firetruck;
import com.system.springboot.backend.entity.Maintenance;
import com.system.springboot.backend.entity.TechnicalReview;
import com.system.springboot.backend.service.FiretruckService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/firetruck")
public class FiretruckRestController {

    private final FiretruckService firetruckService;


    /**
     * endpoint findAll
     * @return a list objects of type firetruck or exception
     */
    @GetMapping
    public ResponseEntity<List<Firetruck>> findAllFiretrucks(){
        return new ResponseEntity <> (firetruckService.findAllFiretruck(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Firetruck> findCompanyById(@PathVariable Long id){
        return new ResponseEntity<>(firetruckService.findFiretruckById(id), HttpStatus.OK);
    }


    /**
     *
     * @param firetruck
     * @return
     */
    @PostMapping
    public ResponseEntity<Firetruck> saveFiretruck(@Validated @RequestBody Firetruck firetruck){
        return new ResponseEntity<>(firetruckService.saveFiretruck(firetruck),HttpStatus.CREATED);
    }

    /**
     *
     * @param firetruck
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Firetruck> UpdateFiretruck(@Validated @RequestBody Firetruck firetruck, @PathVariable Long id){
        Firetruck firetruckNew = firetruckService.findFiretruckById(id);
        firetruckNew = firetruck;
        firetruckNew.setId(id);
        return new ResponseEntity<>(firetruckService.saveFiretruck(firetruckNew),HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFiretruck(@PathVariable Long id){
        firetruckService.deleteFiretruck(id);
        return new ResponseEntity<>("Firetruck successfully deleted",HttpStatus.OK);
    }


    /**
     * ------------------------------- Maintenance--------------------------------------
     */

    /**
     * endpoint findAll
     * @return a list objects of type maintenance or exception
     */
    @GetMapping("/maintenance")
    public ResponseEntity<List<Maintenance>> findAllMaintenance(){
        return new ResponseEntity <> (firetruckService.findAllMaintenance(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/maintenance/{id}")
    public ResponseEntity<Maintenance> findMaintenanceById(@PathVariable Long id){
        return new ResponseEntity<>(firetruckService.findMaintenanceById(id), HttpStatus.OK);
    }


    /**
     *
     * @param maintenance
     * @return
     */
    @PostMapping("/maintenance")
    public ResponseEntity<Maintenance> saveMaintenance(@Validated @RequestBody Maintenance maintenance){
        return new ResponseEntity<>(firetruckService.saveMaintenance(maintenance),HttpStatus.CREATED);
    }

    /**
     *
     * @param maintenance
     * @param id
     * @return
     */
    @PutMapping("/maintenance/{id}")
    public ResponseEntity<Maintenance> UpdateMaintenance(@Validated @RequestBody Maintenance maintenance, @PathVariable Long id){
        Maintenance maintenanceNew = firetruckService.findMaintenanceById(id);
        maintenanceNew = maintenance;
        maintenanceNew.setId(id);
        return new ResponseEntity<>(firetruckService.saveMaintenance(maintenanceNew),HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/maintenance/{id}")
    public ResponseEntity<?> deleteMaintenance(@PathVariable Long id){
        firetruckService.deleteMaintenance(id);
        return new ResponseEntity<>("Maintenance successfully deleted",HttpStatus.OK);
    }

    /**
     * ------------------------------- TechnicalReview--------------------------------------
     */

    /**
     * endpoint findAll
     * @return a list objects of type technicalReview or exception
     */
    @GetMapping("/technicalReview")
    public ResponseEntity<List<TechnicalReview>> findAllTechnicalReview(){
        return new ResponseEntity <> (firetruckService.findAllTechnicalReview(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/technicalReview/{id}")
    public ResponseEntity<TechnicalReview> findTechnicalReviewById(@PathVariable Long id){
        return new ResponseEntity<>(firetruckService.findTechnicalReviewById(id), HttpStatus.OK);
    }


    /**
     *
     * @param technicalReview
     * @return
     */
    @PostMapping("/technicalReview")
    public ResponseEntity<TechnicalReview> saveTechnicalReview(@Validated @RequestBody TechnicalReview technicalReview){
        return new ResponseEntity<>(firetruckService.saveTechnicalReview(technicalReview),HttpStatus.CREATED);
    }

    /**
     *
     * @param technicalReview
     * @param id
     * @return
     */
    @PutMapping("/technicalReview/{id}")
    public ResponseEntity<TechnicalReview> UpdateTechnicalReview(@Validated @RequestBody TechnicalReview technicalReview, @PathVariable Long id){
        TechnicalReview technicalReviewNew = firetruckService.findTechnicalReviewById(id);
        technicalReviewNew = technicalReview;
        technicalReviewNew.setId(id);
        return new ResponseEntity<>(firetruckService.saveTechnicalReview(technicalReviewNew),HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/technicalReview/{id}")
    public ResponseEntity<?> deleteTechnicalReview(@PathVariable Long id){
        firetruckService.deleteTechnicalReview(id);
        return new ResponseEntity<>("TechnicalReview successfully deleted",HttpStatus.OK);
    }

}
