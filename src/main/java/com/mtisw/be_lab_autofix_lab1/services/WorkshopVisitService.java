package com.mtisw.be_lab_autofix_lab1.services;

import com.mtisw.be_lab_autofix_lab1.entities.WorkshopVisitEntity;
import com.mtisw.be_lab_autofix_lab1.repositories.WorkshopVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkshopVisitService {
    @Autowired
    WorkshopVisitRepository workshopVisitRepository;

    public List<WorkshopVisitEntity> listAllRepairs(){
        return workshopVisitRepository.findAll();
    }

    public List<WorkshopVisitEntity> listRepairByPlateNumber(String plateNumber){
        List<WorkshopVisitEntity> repairs = workshopVisitRepository.findByPlateNumber(plateNumber);
        return repairs;

    }

    public WorkshopVisitEntity saveRepair(WorkshopVisitEntity repair) {
        return workshopVisitRepository.save(repair);
    }

    public Optional<WorkshopVisitEntity> findRepairById(Long id) {
        return  workshopVisitRepository.findById(id);
    }

}
