package com.car.api;

import com.car.models.Warehouses;
import com.car.services.CarsManagementServices;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cars")
public class CarMgmtController {

    public static final Logger logger = Logger.getLogger(CarMgmtController.class);

    @Autowired
    CarsManagementServices carsManagementServices;

    /**
     * This method has return all cars from all warehouses.
     * @return List of all cars.
     */
    @GetMapping(path = "/allCars")
    private ResponseEntity<List<Warehouses>> getAllCarsFromAllWarehouses() {
        logger.info("fetch all cars from warehouse");
        List<Warehouses> warehouses = carsManagementServices.getCarsFromAllWarehouses();
        return new ResponseEntity(warehouses, HttpStatus.OK);
    }

    /**
     * Method has the capability to add or update cars into the database.
     *
     * @param warehouses
     * @return ResponseEntity<Warehouses></>
     */
    @PostMapping(path = "/addCars")
    private ResponseEntity<Warehouses> saveOrUpdateCarsIntoWarehouses(@RequestBody Warehouses[] warehouses) {
        logger.info("save cars into warehouse");
        carsManagementServices.saveOrUpdateCarsIntoWarehouses(warehouses);
        return new ResponseEntity(warehouses, HttpStatus.OK);
    }
}
