package com.mtisw.be_lab_autofix_lab1.services;

import com.mtisw.be_lab_autofix_lab1.entities.RepairEntity;
import com.mtisw.be_lab_autofix_lab1.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {
    @Autowired
    RepairRepository repairRepository;

    public List<RepairEntity> listAllRepairs(){
        return repairRepository.findAll();
    }

    public List<RepairEntity> listRepairByPlateNumber(String plateNumber){
        List<RepairEntity> repairs = repairRepository.findByPlateNumber(plateNumber);
        return repairs;

    }

    public RepairEntity saveRepair(RepairEntity repair) {
        return repairRepository.save(repair);
    }

}
