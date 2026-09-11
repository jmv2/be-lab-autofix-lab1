package com.mtisw.be_lab_autofix_lab1.repositories;

import com.mtisw.be_lab_autofix_lab1.entities.RepairEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<RepairEntity, Long> {
    public List<RepairEntity> findByPlateNumber(String plateNumber);
}
