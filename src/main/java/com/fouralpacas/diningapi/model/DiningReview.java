package com.fouralpacas.diningapi.model;

import com.fouralpacas.diningapi.model.Admin;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Optional;

@Getter
@Setter
@Entity
@Table(name="DININGREVIEWS")
public class DiningReview {

    @Setter(AccessLevel.PUBLIC)

    @GeneratedValue
    @Id
    private Long id;

    public String username;

    //optional values
    public Integer peanutScore;
    public Integer eggScore;
    public Integer dairyScore;
    public String commentary;

    private DiningReviewStatus reviewStatus;


}
