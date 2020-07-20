package com.system.springboot.backend.service;

import com.system.springboot.backend.entity.*;
import com.system.springboot.backend.exception.InternalServerErrorException;
import com.system.springboot.backend.exception.NotFoundException;
import com.system.springboot.backend.repository.FiretruckRepository;
import com.system.springboot.backend.repository.MaintenanceRepository;
import com.system.springboot.backend.repository.TechnicalReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FiretruckService {
    /**
     * injection of dependencies by constructor
     */
    private final FiretruckRepository firetruckRepository;
    private final MaintenanceRepository maintenanceRepository;
    private final TechnicalReviewRepository technicalReviewRepository;

    /**
     * methods firetruck
     */
    /**
     *
     * @return
     */
    public List<Firetruck> findAllFiretruck(){
        List<Firetruck> listFiretruck = new ArrayList<>();

        Optional.ofNullable(firetruckRepository.findAll())
                .orElseThrow(()-> new NotFoundException("empty list", new Exception("")))
                .forEach(listFiretruck::add);
        return listFiretruck;
    }

    /**
     *
     * @param id
     * @return
     */
    public Firetruck findFiretruckById(Long id){
        return firetruckRepository.findById(id).orElseThrow(()-> new NotFoundException("firetruck not exist",new Exception("")));
    }

    /**
     *
     * @param firetruck
     * @return
     */
    public Firetruck saveFiretruck(Firetruck firetruck){
        return Optional.of(firetruckRepository.save(firetruck))
                .orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
    }

    /**
     *
     * @param id
     */
    public void deleteFiretruck(Long id){
        Firetruck firetruck=findFiretruckById(id);
        firetruckRepository.delete(firetruck);
    }

    /**
     * methods compartment
     */

    /**
     *
     * @return
     */
    public List<Maintenance> findAllMaintenance(){
        List<Maintenance> listMaintenance = new ArrayList<>();

        Optional.ofNullable(maintenanceRepository.findAll())
                .orElseThrow(()-> new NotFoundException("empty list", new Exception("")))
                .forEach(listMaintenance::add);
        return listMaintenance;
    }

    /**
     *
     * @param id
     * @return
     */
    public Maintenance findMaintenanceById(Long id){
        return maintenanceRepository.findById(id).orElseThrow(()-> new NotFoundException("firetruck not exist",new Exception("")));
    }

    /**
     *
     * @param maintenance
     * @return
     */
    public Maintenance saveMaintenance(Maintenance maintenance){
        return Optional.of(maintenanceRepository.save(maintenance))
                .orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
    }

    /**
     *
     * @param id
     */
    public void deleteMaintenance(Long id){
        Maintenance maintenance=findMaintenanceById(id);
        maintenanceRepository.delete(maintenance);
    }

    /**
     * methods technicalReview
     */

    /**
     *
     * @return
     */
    public List<TechnicalReview> findAllTechnicalReview(){
        List<TechnicalReview> listTechnicalReview = new ArrayList<>();

        Optional.ofNullable(technicalReviewRepository.findAll())
                .orElseThrow(()-> new NotFoundException("empty list", new Exception("")))
                .forEach(listTechnicalReview::add);
        return listTechnicalReview;
    }

    /**
     *
     * @param id
     * @return
     */
    public TechnicalReview findTechnicalReviewById(Long id){
        return technicalReviewRepository.findById(id).orElseThrow(()-> new NotFoundException("firetruck not exist",new Exception("")));
    }

    /**
     *
     * @param technicalReview
     * @return
     */
    public TechnicalReview saveTechnicalReview(TechnicalReview technicalReview){
        return Optional.of(technicalReviewRepository.save(technicalReview))
                .orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
    }

    /**
     *
     * @param id
     */
    public void deleteTechnicalReview(Long id){
        TechnicalReview technicalReview=findTechnicalReviewById(id);
        technicalReviewRepository.delete(technicalReview);
    }

}
