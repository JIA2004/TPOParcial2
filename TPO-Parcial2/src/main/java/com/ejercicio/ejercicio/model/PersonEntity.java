package com.ejercicio.ejercicio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Person")
public class PersonEntity {
    @Id
    private String name;
    private Integer born;

    // Constructor
    public PersonEntity(Integer born, String name) {
        this.born = born;
        this.name = name;
    }

    // Default constructor (necesario para frameworks como Spring)
    public PersonEntity() {
    }

    // Getters
    public String getName() {
        return name;
    }

    public Integer getBorn() {
        return born;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(Integer born) {
        this.born = born;
    }

    // toString() method
    @Override
    public String toString() {
        return "PersonEntity{" +
                "name='" + name + '\'' +
                ", born=" + born +
                '}';
    }
}
