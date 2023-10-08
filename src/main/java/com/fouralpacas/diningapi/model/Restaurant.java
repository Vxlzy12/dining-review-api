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
@Table(name="RESTAURANTS")
public class Restaurant {

    @Setter(AccessLevel.PUBLIC)

    @GeneratedValue
    @Id
    private Long id;

    private String name;
    private Integer overallScore;
    private Integer peanutScore;
    private Integer eggScore;
    private Integer dairyScore;

}
