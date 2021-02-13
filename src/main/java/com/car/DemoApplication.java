package com.car;

import com.car.models.Cars;
import com.car.models.Location;
import com.car.models.Vehicle;
import com.car.models.Warehouses;
import com.car.repositiories.WarehouseRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	public static final Logger logger = Logger.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	WarehouseRepository warehouseRepository;

	@Override
	public void run(String... args) throws Exception {
		logger.info("Mock data persist operation has been started...");
		List<Vehicle> vehicleList = new ArrayList<>();
		Warehouses warehouses = new Warehouses();
		Location location = new Location();

		Cars cars = new Cars();
		warehouses.set_id(1);
		warehouses.setName("Warehouse A");
		location.setLat("47.13111");
		location.setAlong("-61.54801");
		warehouses.setLocation(location);
		cars.setLocation("West wing");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.set_id(1);
		vehicle1.setMake("Volkswagen");
		vehicle1.setModel("Jetta III");
		vehicle1.setYear_model(1995);
		vehicle1.setPrice(12947.52);
		vehicle1.setLicensed(true);
		vehicle1.setDate_added("2018-09-18");

		vehicleList.add(vehicle1);
		Vehicle vehicle2 = new Vehicle();
		vehicle2.set_id(2);
		vehicle2.setMake("Chevrolet");
		vehicle2.setModel("Corvette");
		vehicle2.setYear_model(2004);
		vehicle2.setPrice(20019.64);
		vehicle2.setLicensed(true);
		vehicle2.setDate_added("2018-01-27");
		vehicleList.add(vehicle2);

		cars.setVehicles(vehicleList);
		warehouses.setCars(cars);
		warehouseRepository.save(warehouses);
		logger.info("Mock data persist operation has been completed");
	}
}
