package com.muslimdev.hostelmanegement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hostel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostelId;
    private String hostelDescription;
    private String hostelType;
    private String hostelName;
    private String hostelRent;
    private String hostelAddres;

}
