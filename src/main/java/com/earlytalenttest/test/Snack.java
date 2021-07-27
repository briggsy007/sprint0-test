package com.earlytalenttest.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import java.util.UUID;

@Entity
public class Snack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private Double cost; 

    public Snack() {}
    public Snack(String name, UUID id, Double cost){
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public UUID getId(){
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost(){
        return this.cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
