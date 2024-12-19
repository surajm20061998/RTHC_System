// File: src/main/java/com/example/healthcare_system/repository/DeviceTypeRepository.java
package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Integer> {
    // Find DeviceTypes by manufacturer
    List<DeviceType> findByManufacturer(String manufacturer);

    // Find DeviceTypes by name containing a specific keyword (case-insensitive)
    List<DeviceType> findByNameContainingIgnoreCase(String keyword);

    // Additional custom query methods can be added here if needed
}
