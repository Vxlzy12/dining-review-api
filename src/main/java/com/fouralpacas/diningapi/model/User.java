package com.fouralpacas.diningapi.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="USERS")
public class User {
    @Setter(AccessLevel.PUBLIC)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String displayName;
    private String city;
    private String state;
    private Integer zipCode;
    private Boolean peanutAllergy;
    private Boolean eggAllergy;
    private Boolean dairyAllergy;



}
