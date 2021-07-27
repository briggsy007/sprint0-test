package com.earlytalenttest.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityRepo repo;
    
    @GetMapping("/test")
    public String sayHi() {
        return "Hello World";
    }

    //Create
    @PostMapping("/add") 
    public City addCity(@RequestBody City city){
        return repo.save(city);
    }

    //Read
    @GetMapping("/get/{id}")
    public City getCity(@PathVariable Long id) {
        try {
            return repo.findById(id).get();
        }
        catch(Exception e) {
            return null;
        }
        
        
    }

    @GetMapping("/getAll")
    public List<City> getAllCity() {
        return repo.findAll();
    }

    //Update
    @PutMapping("/update/{id}")
    public City update(@PathVariable Long id, @RequestBody City newCity) {
        try {
            City city = repo.findById(id).get();
            if(newCity.getName() != null) {
                city.setName(newCity.getName());
            }
            if(newCity.getState() != null) {
                city.setState(newCity.getState());
            }
            if(newCity.getPopulation() != null) {
                city.setPopulation(newCity.getPopulation());
            }
            return repo.save(city);
        }
        catch(Exception e) {
            return null;
        }

    }

    //Destroy
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            City toDelete = repo.findById(id).get();
            repo.delete(toDelete);  
            return "deleted city with name " + toDelete.getName();
        }
        catch(Exception e) {
            return null;
        }
      
    }



    
}