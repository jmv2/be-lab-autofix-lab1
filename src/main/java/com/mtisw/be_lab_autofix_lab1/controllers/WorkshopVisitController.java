package com.mtisw.be_lab_autofix_lab1.controllers;

import com.mtisw.be_lab_autofix_lab1.entities.WorkshopVisitEntity;
import com.mtisw.be_lab_autofix_lab1.services.WorkshopVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/repair")
@CrossOrigin("*")
public class WorkshopVisitController {
    @Autowired
    WorkshopVisitService workshopVisitService;

    @GetMapping
    public ResponseEntity<List<WorkshopVisitEntity>> listAllRepairs() {
        List<WorkshopVisitEntity> repairs = workshopVisitService.listAllRepairs();
        return ResponseEntity.ok(repairs);
    }

    @PostMapping
    public ResponseEntity<WorkshopVisitEntity> saveRepair(@RequestBody WorkshopVisitEntity repair) {
        WorkshopVisitEntity newRepair = workshopVisitService.saveRepair(repair);
        return ResponseEntity.ok(newRepair);
    }


}
