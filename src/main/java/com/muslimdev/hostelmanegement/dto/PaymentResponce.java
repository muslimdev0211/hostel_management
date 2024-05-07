package com.muslimdev.hostelmanegement.dto;

import com.muslimdev.hostelmanegement.entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PaymentResponce {
    private Users userId;
    private String paymentDescription;
    private String paymentAmount;
    private Date paymentDate;
}

