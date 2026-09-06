package com.mtisw.be_lab_autofix_lab1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtisw.be_lab_autofix_lab1.entities.VehicleEntity;

@Repository 
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long>{
    
}
