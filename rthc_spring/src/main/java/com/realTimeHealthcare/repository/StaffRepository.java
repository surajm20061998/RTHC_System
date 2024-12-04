package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*; 

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    // Find staff by email
    Staff findByEmail(String email);

    // Find staff by role
    List<Staff> findByRole(String role);
}
