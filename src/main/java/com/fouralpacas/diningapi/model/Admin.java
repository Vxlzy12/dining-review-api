package com.fouralpacas.diningapi.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;

@Getter
@Setter
@Entity
public class Admin {

    @GeneratedValue
    @Id
    private Long id;
    public Boolean reviewPending;
    public Boolean reviewAccepted;
}
