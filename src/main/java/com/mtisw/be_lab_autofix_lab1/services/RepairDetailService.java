package com.mtisw.be_lab_autofix_lab1.services;

import com.mtisw.be_lab_autofix_lab1.entities.RepairDetailEntity;
import com.mtisw.be_lab_autofix_lab1.repositories.RepairDetailRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairDetailService {
    @Autowired
    RepairDetailRepository repairDetailRepository;

    @Autowired
    WorkshopVisitService workshopVisitService;

    public List<RepairDetailEntity> listRepairByRepairId(Long id){
        return repairDetailRepository.findByRepairId(id);
    }

    public RepairDetailEntity saveRepair(RepairDetailEntity repairDetail) {
        if (workshopVisitService
                .findRepairById(repairDetail.getRepairId())
                .isEmpty()) {
            return new RepairDetailEntity();
        }
        return repairDetailRepository.save(repairDetail);
    }

    public List<RepairDetailEntity> listAllRepairs() {
        return repairDetailRepository.findAll();
    }
}
