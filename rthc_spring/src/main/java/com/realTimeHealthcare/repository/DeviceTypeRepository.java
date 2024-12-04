package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Integer> {
    // Custom query methods can be added here if needed
}
