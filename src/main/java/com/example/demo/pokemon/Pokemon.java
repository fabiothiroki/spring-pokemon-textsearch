package com.example.demo.pokemon;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
@JsonPropertyOrder({ "name", "type1", "type2" })
public class Pokemon {

    public Pokemon() {}

    public Pokemon(
            final String name,
            final String type1,
            final String type2) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
    }

    @Id
    @GeneratedValue
    public Long id;

    @Column
    public String name;

    @Column
    public String type1;

    @Column
    public String type2;
}
