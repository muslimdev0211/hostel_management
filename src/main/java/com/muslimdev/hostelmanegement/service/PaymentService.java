package com.muslimdev.hostelmanegement.service;

import com.muslimdev.hostelmanegement.dto.PaymentDto;
import com.muslimdev.hostelmanegement.dto.PaymentResponce;
import com.muslimdev.hostelmanegement.entity.Payments;
import com.muslimdev.hostelmanegement.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserService userService;

    public PaymentService(PaymentRepository paymentRepository, UserService userService) {
        this.paymentRepository = paymentRepository;
        this.userService = userService;
    }

    public PaymentResponce addPayment(PaymentDto paymentDto) {
        paymentRepository.save(toEntity(paymentDto));
        return toResponce(toEntity(paymentDto));
    }

    public Payments toEntity(PaymentDto paymentDto){
        Payments payments = new Payments();
        if (paymentDto.getUserId()!= null){
            payments.setUserId(userService.getEntityById(paymentDto.getUserId()));
        }
        payments.setPaymentDate(paymentDto.getPaymentDate());
        payments.setPaymentAmount(paymentDto.getPaymentAmount());
        payments.setPaymentDescription(paymentDto.getPaymentDescription());
        return payments;
    }
    public PaymentResponce toResponce(Payments payments){
        PaymentResponce paymentResponce = new PaymentResponce();
        paymentResponce.setUserId(userService.getEntityById(payments.getUserId().getId()));
        paymentResponce.setPaymentAmount(payments.getPaymentAmount());
        paymentResponce.setPaymentDate(payments.getPaymentDate());
        paymentResponce.setPaymentDescription(payments.getPaymentDescription());
        return paymentResponce;

    }

    public List<PaymentResponce> getPayments() {
        List <PaymentResponce> paymentResponcesOptional = new ArrayList<>();

        for (Payments payments: paymentRepository.findAll()){
            paymentResponcesOptional.add(toResponce(payments));
        }
        return paymentResponcesOptional;

    }

    public PaymentResponce getPayment(Long id) {
        Optional <Payments> paymentResponceOptional = paymentRepository.findById(id);
        return toResponce(paymentResponceOptional.get());
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);

    }
}
