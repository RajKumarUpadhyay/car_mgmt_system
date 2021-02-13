package com.car;

import com.car.models.Cars;
import com.car.models.Location;
import com.car.models.Vehicle;
import com.car.models.Warehouses;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getShouldReturnWarehouseObject() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/cars/allCars",
                Warehouses[].class));
    }

    @Test
    public void addCarsIntoWarehouse() throws Exception {
        List<Vehicle> vehicleList = new ArrayList<>();
        Warehouses warehouses = new Warehouses();
        Location location = new Location();

        Cars cars = new Cars();
        warehouses.set_id(1);
        warehouses.setName("Warehouse B");
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

        cars.setVehicles(vehicleList);
        warehouses.setCars(cars);

        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/cars/addCars",
                warehouses, Warehouses[].class));
    }
}
