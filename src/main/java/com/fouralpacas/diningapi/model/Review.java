package com.fouralpacas.diningapi.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="DININGREVIEWS")
public class Review {

    @Setter(AccessLevel.PUBLIC)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String displayName;

    public Long restaurantId;

    //optional values
    public Integer peanutScore;
    public Integer eggScore;
    public Integer dairyScore;
    public String commentary;

    private ReviewStatus reviewStatus;


}
