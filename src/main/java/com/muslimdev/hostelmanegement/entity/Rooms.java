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
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long roomId;
    private Integer roomExamId;
    private String roomNumber;
    private String roomType;
    private String roomDescription;

}
