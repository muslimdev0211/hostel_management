package com.muslimdev.hostelmanegement.repository;

import com.muslimdev.hostelmanegement.entity.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelRepository extends JpaRepository<Hostel, Long> {

}
