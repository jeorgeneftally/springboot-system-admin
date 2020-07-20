package com.system.springboot.backend.controller;

import com.system.springboot.backend.entity.Compartment;
import com.system.springboot.backend.entity.Material;
import com.system.springboot.backend.service.MaterialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/material")
public class MaterialRestController {

    /**
     * injection by constructor
     */
    private final MaterialService materialService;

    /**
     * endpoint findAll
     * @return a list objects of type material or exception
     */
    @GetMapping
    public ResponseEntity<List<Material>> findAllMaterial(){
        return new ResponseEntity <> (materialService.findAllMaterial(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Material> findMaterialById(@PathVariable Long id){
        return new ResponseEntity<>(materialService.findMaterialById(id), HttpStatus.OK);
    }


    /**
     *
     * @param material
     * @return
     */
    @PostMapping
    public ResponseEntity<Material> saveMaterial(@Validated @RequestBody Material material){
        return new ResponseEntity<>(materialService.saveMaterial(material),HttpStatus.CREATED);
    }

    /**
     *
     * @param material
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Material> UpdateCompartment(@Validated @RequestBody Material material, @PathVariable Long id){
        Material materialNew = materialService.findMaterialById(id);
        materialNew= material;
        materialNew.setId(id);
        return new ResponseEntity<>(materialService.saveMaterial(materialNew),HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMaterial(@PathVariable Long id){
        materialService.deleteMaterial(id);
        return new ResponseEntity<>("Material successfully deleted",HttpStatus.OK);
    }
}
