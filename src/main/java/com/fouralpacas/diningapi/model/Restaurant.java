package com.fouralpacas.diningapi.model;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Setter(AccessLevel.PUBLIC)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer zipCode;
    private Integer overallScore;
    private Integer peanutScore;
    private Integer eggScore;
    private Integer dairyScore;

}
