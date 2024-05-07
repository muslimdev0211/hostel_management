package com.muslimdev.hostelmanegement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PaymentDto {
    private Long userId;
    private String paymentDescription;
    private String paymentAmount;
    private Date paymentDate;


}
