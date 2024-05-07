package com.muslimdev.hostelmanegement.controller;

import com.muslimdev.hostelmanegement.dto.PaymentDto;
import com.muslimdev.hostelmanegement.dto.PaymentResponce;
import com.muslimdev.hostelmanegement.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public PaymentResponce addPayment(@RequestBody PaymentDto paymentDto){

        return paymentService.addPayment(paymentDto);
    }
    @GetMapping("/payments")
    public List<PaymentResponce> getAllPayment(){
       return paymentService.getPayments();
    }
    @GetMapping("/payment/{id}")
    public PaymentResponce getPayment(@PathVariable Long id){
        return paymentService.getPayment(id);
    }
    @DeleteMapping("/payment/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        paymentService.deletePayment(id);
        return ResponseEntity.ok("Deleted");
    }

}
