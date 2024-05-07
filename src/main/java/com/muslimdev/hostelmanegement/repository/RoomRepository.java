package com.muslimdev.hostelmanegement.repository;

import com.muslimdev.hostelmanegement.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Rooms, Long> {

}
