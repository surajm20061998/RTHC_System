package com.realTimeHealthcare.repository;

import com.realTimeHealthcare.model.AlertRequiresAction;
import com.realTimeHealthcare.model.AlertRequiresActionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRequiresActionRepository extends JpaRepository<AlertRequiresAction, AlertRequiresActionId> {
    // Custom query methods can be added here
}
