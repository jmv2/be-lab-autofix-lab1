package com.mtisw.be_lab_autofix_lab1.repositories;

import com.mtisw.be_lab_autofix_lab1.entities.WorkshopVisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopVisitRepository extends JpaRepository<WorkshopVisitEntity, Long> {
    public List<WorkshopVisitEntity> findByPlateNumber(String plateNumber);
}
