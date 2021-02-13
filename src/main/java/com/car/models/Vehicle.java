package com.car.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "VEHICLES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;
    @Column(name = "MAKE")
    private String make;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "YEAR_MODEL")
    private int year_model;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "LICENSED")
    private boolean licensed;
    private @Column(name = "DATE_ADDED")
    String date_added;
}

