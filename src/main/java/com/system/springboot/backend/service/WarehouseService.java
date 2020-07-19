package com.system.springboot.backend.service;

import com.system.springboot.backend.entity.CompartmentDetail;
import com.system.springboot.backend.entity.Warehouse;
import com.system.springboot.backend.entity.WarehouseDetail;
import com.system.springboot.backend.exception.InternalServerErrorException;
import com.system.springboot.backend.exception.NotFoundException;
import com.system.springboot.backend.repository.WarehouseDetailRepository;
import com.system.springboot.backend.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WarehouseService {


    private final WarehouseRepository warehouseRepository;
    private final WarehouseDetailRepository warehouseDetailRepository;

    /**
     * methods Warehouse_-------------------------------------------------------
     */

    /**
     *
     * @return
     */
    public List<Warehouse> findAllWarehouse(){
        List<Warehouse> listWarehouse = new ArrayList<>();

        Optional.ofNullable(warehouseRepository.findAll())
                .orElseThrow(()-> new NotFoundException("empty list", new Exception("")))
                .forEach(listWarehouse::add);
        return listWarehouse;
    }

    /**
     *
     * @param id
     * @return
     */
    public Warehouse findWarehouseById(Long id){
        return warehouseRepository.findById(id).orElseThrow(()-> new NotFoundException("warehouse not exist",new Exception("")));
    }

    /**
     *
     * @param warehouse
     * @return
     */
    public Warehouse saveWarehouse(Warehouse warehouse){
        return Optional.of(warehouseRepository.save(warehouse))
                .orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
    }

    /**
     *
     * @param id
     */
    public void deleteWarehouse(Long id){
        Warehouse warehouse=findWarehouseById(id);
        warehouseRepository.delete(warehouse);
    }

    /**
     * methods WarehouseDetail_-----------------------------------------------------
     */

    /**
     *
     * @return
     */
    public List<WarehouseDetail> findAllWarehouseDetail(){
        List<WarehouseDetail> listWarehouseDetail = new ArrayList<>();

        Optional.ofNullable(warehouseDetailRepository.findAll())
                .orElseThrow(()-> new NotFoundException("empty list", new Exception("")))
                .forEach(listWarehouseDetail::add);
        return listWarehouseDetail;
    }

    /**
     *
     * @param id
     * @return
     */
    public WarehouseDetail findWarehouseDetailById(Long id){
        return warehouseDetailRepository.findById(id).orElseThrow(()-> new NotFoundException("warehouseDetail not exist",new Exception("")));
    }

    /**
     *
     * @param warehouseDetail
     * @return
     */
    public WarehouseDetail saveWarehouseDetail(WarehouseDetail warehouseDetail){
        return Optional.of(warehouseDetailRepository.save(warehouseDetail))
                .orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
    }

    /**
     *
     * @param id
     */
    public void deleteWarehouseDetail(Long id){
        WarehouseDetail warehouseDetail=findWarehouseDetailById(id);
        warehouseDetailRepository.delete(warehouseDetail);
    }
}
