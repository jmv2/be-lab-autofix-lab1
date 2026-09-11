package com.mtisw.be_lab_autofix_lab1.controllers;

import com.mtisw.be_lab_autofix_lab1.entities.RepairEntity;
import com.mtisw.be_lab_autofix_lab1.entities.VehicleEntity;
import com.mtisw.be_lab_autofix_lab1.services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/repair")
@CrossOrigin("*")
public class RepairController {
    @Autowired
    RepairService repairService;


    @GetMapping
    public ResponseEntity<List<RepairEntity>> listAllRepairs() {
        List<RepairEntity> repairs = repairService.listAllRepairs();
        return ResponseEntity.ok(repairs);
    }

    @PostMapping
    public ResponseEntity<RepairEntity> saveRepair(@RequestBody RepairEntity repair) {
        RepairEntity newRepair = repairService.saveRepair(repair);
        return ResponseEntity.ok(repair);
    }
}
