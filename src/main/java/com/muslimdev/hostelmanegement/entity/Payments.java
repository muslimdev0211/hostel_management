package com.muslimdev.hostelmanegement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Users userId;
    private String paymentDescription;
    private String paymentAmount;
    private Date paymentDate;
}
