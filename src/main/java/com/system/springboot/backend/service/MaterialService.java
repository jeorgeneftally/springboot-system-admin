package com.system.springboot.backend.service;

import com.system.springboot.backend.entity.Company;
import com.system.springboot.backend.entity.Material;
import com.system.springboot.backend.exception.InternalServerErrorException;
import com.system.springboot.backend.exception.NotFoundException;
import com.system.springboot.backend.repository.MaterialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MaterialService {


    private final MaterialRepository materialRepository;

    /**
     *
     * @return
     */
    public List<Material> findAllMaterial(){
        List<Material> listMaterial = new ArrayList<>();

        Optional.ofNullable(materialRepository.findAll())
                .orElseThrow(()-> new NotFoundException("empty list", new Exception("")))
                .forEach(listMaterial::add);
        return listMaterial;
    }

    /**
     *
     * @param id
     * @return
     */
    public Material findMaterialById(Long id){
        return materialRepository.findById(id).orElseThrow(()-> new NotFoundException("material not exist",new Exception("")));
    }

    /**
     *
     * @param material
     * @return
     */
    public Material saveMaterial(Material material){
        return Optional.of(materialRepository.save(material))
                .orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
    }

    /**
     *
     * @param id
     */
    public void deleteMaterial(Long id){
        Material material=findMaterialById(id);
        materialRepository.delete(material);
    }

    /**
     *
     * @param name
     * @return
     */
    public List<Material> findAllMaterialByName(String name){
        List<Material> listMaterial = new ArrayList<>();

        Optional.ofNullable(materialRepository.findMaterialsByNameContaining(name))
                .orElseThrow(()-> new NotFoundException("empty list", new Exception("")))
                .forEach(listMaterial::add);
        return listMaterial;
    }
}
