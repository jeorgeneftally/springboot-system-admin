package com.system.springboot.backend.controller;

import com.system.springboot.backend.entity.Compartment;
import com.system.springboot.backend.entity.CompartmentDetail;
import com.system.springboot.backend.entity.Warehouse;
import com.system.springboot.backend.entity.WarehouseDetail;
import com.system.springboot.backend.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/warehouse")
public class WarehouseRestController {

    /**
     * injection by constructor
     */

    private final WarehouseService warehouseService;

    /**
     * endpoint findAll
     * @return a list objects of type warehouse or exception
     */
    @GetMapping
    public ResponseEntity<List<Warehouse>> findAllWarehouse(){
        return new ResponseEntity <> (warehouseService.findAllWarehouse(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> findWarehouseById(@PathVariable Long id){
        return new ResponseEntity<>(warehouseService.findWarehouseById(id), HttpStatus.OK);
    }


    /**
     *
     * @param warehouse
     * @return
     */
    @PostMapping
    public ResponseEntity<Warehouse> saveWarehouse(@Validated @RequestBody Warehouse warehouse){
        return new ResponseEntity<>(warehouseService.saveWarehouse(warehouse),HttpStatus.CREATED);
    }

    /**
     *
     * @param warehouse
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> UpdateWarehouse(@Validated @RequestBody Warehouse warehouse, @PathVariable Long id){
        Warehouse warehouseNew = warehouseService.findWarehouseById(id);
        warehouseNew = warehouse;
        warehouseNew.setId(id);
        return new ResponseEntity<>(warehouseService.saveWarehouse(warehouseNew),HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWarehouse(@PathVariable Long id){
        warehouseService.deleteWarehouse(id);
        return new ResponseEntity<>("Warehouse successfully deleted",HttpStatus.OK);
    }


    /**
     * endpoint findAll
     * @return a list objects of type WarehouseDetail or exception
     */
    @GetMapping("/detail")
    public ResponseEntity<List<WarehouseDetail>> findAllWarehouseDetail(){
        return new ResponseEntity <> (warehouseService.findAllWarehouseDetail(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<WarehouseDetail> findWarehouseDetailById(@PathVariable Long id){
        return new ResponseEntity<>(warehouseService.findWarehouseDetailById(id), HttpStatus.OK);
    }


    /**
     *
     * @param warehouseDetail
     * @return
     */
    @PostMapping("/detail")
    public ResponseEntity<WarehouseDetail> saveWarehouseDetail(@Validated @RequestBody WarehouseDetail warehouseDetail){
        return new ResponseEntity<>(warehouseService.saveWarehouseDetail(warehouseDetail),HttpStatus.CREATED);
    }

    /**
     *
     * @param warehouseDetail
     * @param id
     * @return
     */
    @PutMapping("detail/{id}")
    public ResponseEntity<WarehouseDetail> UpdateWarehouseDetail(@Validated @RequestBody WarehouseDetail warehouseDetail, @PathVariable Long id){
        WarehouseDetail warehouseDetailNew = warehouseService.findWarehouseDetailById(id);
        warehouseDetailNew= warehouseDetail;
        warehouseDetailNew.setId(id);
        return new ResponseEntity<>(warehouseService.saveWarehouseDetail(warehouseDetailNew),HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("detail/{id}")
    public ResponseEntity<?> deleteCompartmentDetail(@PathVariable Long id){
        warehouseService.deleteWarehouseDetail(id);
        return new ResponseEntity<>("WarehouseDetail successfully deleted",HttpStatus.OK);
    }
}
