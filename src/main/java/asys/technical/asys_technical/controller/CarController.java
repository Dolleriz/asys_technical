package asys.technical.asys_technical.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import asys.technical.asys_technical.model.Car;
import asys.technical.asys_technical.repository.CarRepository;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    @GetMapping("/findCar/{VIN}")
    public ResponseEntity<?> findCarByVIN(@PathVariable(value = "VIN") UUID VIN) {
        Car car = carRepository.findById(VIN).orElseThrow();
        return ResponseEntity.ok().body("Succesfully found car: \n"
            + car.getMake() + " " + car.getModel() + "\n"
            + "with VIN: " + car.getVIN() + "\n"
            + "and mileage: " + car.getMileage() + "\n"
            + "created at: " + car.getCreation_Date());
    }

    @PostMapping("/createCar")
    public ResponseEntity<?> createCar(@Validated @RequestBody Car car) {
        carRepository.save(car);

        return ResponseEntity.ok().body("Succesfully created car: \n" 
            + car.getMake() + " " + car.getModel() + "\n"
            + "with VIN: " + car.getVIN() + "\n"
            + "and mileage: " + car.getMileage() + "\n"
            + "created at: " + car.getCreation_Date());
    }

    @PatchMapping("/updateCar/{VIN}")
    public ResponseEntity<?> updateCarMake(@RequestBody Car carDetails, @PathVariable(value = "VIN") UUID VIN) {
        Car car = carRepository.findById(VIN).orElseThrow();
        if (carDetails.getMake() != null) {
            car.setMake(carDetails.getMake());
        }
        
        if (carDetails.getModel() != null) {
            car.setModel(carDetails.getModel());
        }
        
        if (carDetails.getMileage() != -1) {
            car.setMileage(carDetails.getMileage());
        }

        carRepository.save(car);

        return ResponseEntity.ok().body("Succesfully updated car to: \n" 
            + car.getMake() + " " + car.getModel());
    }

    @DeleteMapping("/deleteCar/{VIN}")
    public ResponseEntity<?> deleteCar(@PathVariable(value = "VIN") UUID VIN) {
        Car car = carRepository.findById(VIN).orElseThrow();
        carRepository.delete(car);

        return ResponseEntity.ok().body("Succesfully deleted car: \n" 
            + car.getMake() + " " + car.getModel());
    }
}