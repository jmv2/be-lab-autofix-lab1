package com.mtisw.be_lab_autofix_lab1.repositories;

import com.mtisw.be_lab_autofix_lab1.entities.RepairDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairDetailRepository extends JpaRepository<RepairDetailEntity, Long> {
    public List<RepairDetailEntity> findByRepairId(Long id);
}
