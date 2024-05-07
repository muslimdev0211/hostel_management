package com.muslimdev.hostelmanegement.repository;

import com.muslimdev.hostelmanegement.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {

}
