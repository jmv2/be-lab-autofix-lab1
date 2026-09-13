package com.mtisw.be_lab_autofix_lab1.controllers;

import com.mtisw.be_lab_autofix_lab1.entities.RepairDetailEntity;
import com.mtisw.be_lab_autofix_lab1.services.RepairDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/repair/details")
@CrossOrigin("*")
public class RepairDetailController {
    @Autowired
    RepairDetailService repairDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<List<RepairDetailEntity>> getRepairByRepairId() {
        List<RepairDetailEntity> repairs = repairDetailService.listAllRepairs();
        return ResponseEntity.ok(repairs);
    }

    @PostMapping
    public ResponseEntity<RepairDetailEntity> saveRepairDetail(@RequestBody RepairDetailEntity repairDetail) {
        RepairDetailEntity newRepair = repairDetailService.saveRepair(repairDetail);
        return ResponseEntity.ok(newRepair);
    }


}
