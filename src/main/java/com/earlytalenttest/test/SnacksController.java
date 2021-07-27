package com.earlytalenttest.test;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;


@RestController
@RequestMapping("/snacks")
public class SnacksController {
 

    @Autowired
    SnackRepository repository;

    @GetMapping
    public List<Snack> getAllSnacks() {
        return repository.findAll();
    }

    // Read by ID
    @GetMapping("/{id}")
    public Snack readById(@PathVariable UUID id){
        return repository.findById(id).orElse(null);
    } 



    // Create
    @PostMapping
    public Snack createSnack(@RequestBody Snack snack){
        return repository.save(snack);
    } 

  
    // Update by ID
    @PutMapping("/{id}")
    public Snack updateSnack(@PathVariable UUID id, @RequestBody Snack snack) {
        Snack snackToEdit = repository.findById(id).orElse(null);
        if(snackToEdit == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Snack not found.");
        }

        snackToEdit.setName(snack.getName());
        snackToEdit.setCost(snack.getCost());
        return repository.save(snackToEdit);
    }


    // Delete by ID
    @DeleteMapping("/{id}")
    public void deleteSnack(@PathVariable UUID id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}