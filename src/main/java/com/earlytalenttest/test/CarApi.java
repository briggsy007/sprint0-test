package com.earlytalenttest.test;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
//@RequestMapping("/cars")
public class CarApi {

    @Autowired
    CarRepository repo;

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return repo.findAll();
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable Integer id){
        return repo.findById(id).get();
    }
    

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car) {
        return repo.save(car);
    }

    @PostMapping("/cars/{id}/year")
    public Car updateYear(@PathVariable Integer id, @RequestBody Car car) {
        Car carToEdit = repo.findById(id).orElse(null);

        if(carToEdit == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found");
        }

        carToEdit.setYear(car.getYear());
        return repo.save(carToEdit);
    }

    @PostMapping("/cars/{id}/make")
    public Car updateMake(@PathVariable Integer id, @RequestBody Car car) {
        Car carToEdit = repo.findById(id).orElse(null);

        if(carToEdit == null) {
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found");
        }

        carToEdit.setMake(car.getMake());
        return repo.save(carToEdit);
    }

    @PostMapping("/cars/{id}/model")
    public Car updateModel(@PathVariable Integer id, @RequestBody Car car) {
        Car carToEdit = repo.findById(id).orElse(null);

        if(carToEdit == null) {
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found");
            
        }

        carToEdit.setModel(car.getModel());
        return repo.save(carToEdit);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Integer id){

        if(repo.existsById(id)){
            repo.deleteById(id);
        }else{
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found");
        }

    }




}


