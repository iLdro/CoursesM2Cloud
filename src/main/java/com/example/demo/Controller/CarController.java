package com.example.demo.Controller;

import com.example.demo.DemoApplication;
import com.example.demo.Data.Car;
import com.example.demo.Data.Dates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CarController {

    List<Car> cars = new ArrayList<Car>();

    Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public CarController() {
        Car car = new Car("11AA22", 1000);
        cars.add(car);
        car = new Car("22BB33", 3000);
        cars.add(car);
    }

    @GetMapping("/cars")
    public List<Car> getCars(){
        logger.info("Getting cars");
        return cars;
    }

    @PutMapping(value = "/cars/{plaque}")
    public void rent(
            @PathVariable("plaque") String plateNumber,
            @RequestParam(value="rent", required = true)boolean rent,
            @RequestBody Dates dates) throws CarNotFoundException {

        logger.info("Plate number: " + plateNumber);
        logger.info("Rent: " + rent);
        logger.info("Dates: " + dates);

        Car car = cars.stream().filter(aCar -> aCar.getPlateNumber().equals(plateNumber)).findFirst().orElse(null);
        if(car != null){
            if(rent == true){
                car.setRented(true);
                car.getDates().add(dates);
            } else {
                car.setRented(false);
            }
        } else {
            logger.error("Car not found: " + plateNumber);
            throw new CarNotFoundException(plateNumber);
        }




    }

}


