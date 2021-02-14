package com.car.services;

import com.car.exceptions.ResourceNotFoundException;
import com.car.models.Warehouses;
import com.car.repositiories.WarehouseRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CarsManagementServices {

    public static final Logger logger = Logger.getLogger(CarsManagementServices.class);

    @Autowired
    WarehouseRepository warehouseRepository;

    public List<Warehouses> getCarsFromAllWarehouses() {
        logger.info("fetch records from database....");
        List<Warehouses> warehousesList;

        warehousesList = warehouseRepository.findAll();
        if(warehousesList.size() == 0 || Objects.isNull(warehousesList))
            throw new ResourceNotFoundException("No Record Found!");
        return warehousesList;
    }

    public List<Warehouses> saveOrUpdateCarsIntoWarehouses(List<Warehouses> warehouses) {
        logger.info("save records into database....");
        try {
            warehouses.forEach(warehouseData -> {
                warehouseRepository.save(warehouseData);
            });
        } catch (Exception exception) {
            throw new RuntimeException("Failed to save cars into database. Please check error log: "
                    + exception.getMessage());
        }
        return warehouses;
    }
}
