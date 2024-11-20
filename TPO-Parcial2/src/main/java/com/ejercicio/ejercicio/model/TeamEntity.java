package com.ejercicio.ejercicio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node("Team")
public class TeamEntity {
    @Id
    private final String name;
    private final String city;
    @Relationship(type = "PLAYS_FOR", direction = Relationship.Direction.INCOMING)
    private Set<PlayerEntity> players = new HashSet<>();

    public TeamEntity(String name, String city) {
        this.name = name;
        this.city = city;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Set<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerEntity> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "TeamEntity{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", players=" + players +
                '}';
    }
}
