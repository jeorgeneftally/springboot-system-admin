package com.system.springboot.backend.service;

import com.system.springboot.backend.entity.Compartment;
import com.system.springboot.backend.entity.CompartmentDetail;
import com.system.springboot.backend.entity.Material;
import com.system.springboot.backend.exception.InternalServerErrorException;
import com.system.springboot.backend.exception.NotFoundException;
import com.system.springboot.backend.repository.CompanyRepository;
import com.system.springboot.backend.repository.CompartmentDetailRepository;
import com.system.springboot.backend.repository.CompartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompartmentService {
    /**
     * injection of dependencies by constructor
     */
    private final CompartmentRepository compartmentRepository;
    private final CompartmentDetailRepository compartmentDetailRepository;


    /**
     * methods compartment
     */
    /**
     *
     * @return
     */
    public List<Compartment> findAllCompartment(){
        List<Compartment> listCompartment = new ArrayList<>();

        Optional.ofNullable(compartmentRepository.findAll())
                .orElseThrow(()-> new NotFoundException("empty list", new Exception("")))
                .forEach(listCompartment::add);
        return listCompartment;
    }

    /**
     *
     * @param id
     * @return
     */
    public Compartment findCompartmentById(Long id){
        return compartmentRepository.findById(id).orElseThrow(()-> new NotFoundException("compartment not exist",new Exception("")));
    }

    /**
     *
     * @param compartment
     * @return
     */
    public Compartment saveCompartment(Compartment compartment){
        return Optional.of(compartmentRepository.save(compartment))
                .orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
    }

    /**
     *
     * @param id
     */
    public void deleteCompartment(Long id){
        Compartment compartment=findCompartmentById(id);
        compartmentRepository.delete(compartment);
    }

    /**
     * methods compartmentDetail
     */

    /**
     *
     * @return
     */
    public List<CompartmentDetail> findAllCompartmentDetail(){
        List<CompartmentDetail> listCompartmentDetail = new ArrayList<>();

        Optional.ofNullable(compartmentDetailRepository.findAll())
                .orElseThrow(()-> new NotFoundException("empty list", new Exception("")))
                .forEach(listCompartmentDetail::add);
        return listCompartmentDetail;
    }

    /**
     *
     * @param id
     * @return
     */
    public CompartmentDetail findCompartmentDetailById(Long id){
        return compartmentDetailRepository.findById(id).orElseThrow(()-> new NotFoundException("compartmentDetail not exist",new Exception("")));
    }

    /**
     *
     * @param compartmentDetail
     * @return
     */
    public CompartmentDetail saveCompartment(CompartmentDetail compartmentDetail){
        return Optional.of(compartmentDetailRepository.save(compartmentDetail))
                .orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
    }

    /**
     *
     * @param id
     */
    public void deleteCompartmentDetail(Long id){
        CompartmentDetail compartmentDetail=findCompartmentDetailById(id);
        compartmentDetailRepository.delete(compartmentDetail);
    }


}
