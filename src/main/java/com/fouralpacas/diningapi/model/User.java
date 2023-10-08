package com.fouralpacas.diningapi.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="USERS")
public class User {
    @Setter(AccessLevel.PUBLIC)

    @GeneratedValue
    @Id
    private Long id;

    private String displayName;
    private String city;
    private String state;
    private Integer zipCode;
    private Boolean peanutAllergy;
    private Boolean eggAllergy;
    private Boolean dairyAllergy;



}
