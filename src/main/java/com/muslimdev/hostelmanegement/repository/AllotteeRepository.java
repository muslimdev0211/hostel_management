package com.muslimdev.hostelmanegement.repository;

import com.muslimdev.hostelmanegement.entity.Allotees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllotteeRepository extends JpaRepository<Allotees, Long> {
}
