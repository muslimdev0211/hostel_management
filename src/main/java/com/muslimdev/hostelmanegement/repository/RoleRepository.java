package com.muslimdev.hostelmanegement.repository;

import com.muslimdev.hostelmanegement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
