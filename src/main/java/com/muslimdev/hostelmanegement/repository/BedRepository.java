package com.muslimdev.hostelmanegement.repository;

import com.muslimdev.hostelmanegement.entity.Beds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<Beds, Long> {

}
