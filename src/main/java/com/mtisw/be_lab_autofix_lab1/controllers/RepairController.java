package com.mtisw.be_lab_autofix_lab1.controllers;

import com.mtisw.be_lab_autofix_lab1.entities.RepairDetailEntity;
import com.mtisw.be_lab_autofix_lab1.entities.WorkshopVisitEntity;
import com.mtisw.be_lab_autofix_lab1.services.RepairDetailService;
import com.mtisw.be_lab_autofix_lab1.services.WorkshopVisitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/repairs")
@CrossOrigin("*")
public class RepairController {
    private final WorkshopVisitService workshopVisitService;
    private final RepairDetailService repairDetailService;

    public RepairController(WorkshopVisitService workshopVisitService, RepairDetailService repairDetailService) {
        this.workshopVisitService = workshopVisitService;
        this.repairDetailService = repairDetailService;
    }

    @GetMapping
    public ResponseEntity<List<WorkshopVisitEntity>> listAllRepairs() {
        List<WorkshopVisitEntity> repairs = workshopVisitService.listAllRepairs();
        return ResponseEntity.ok(repairs);
    }

    @GetMapping("/{repairId}")
    public ResponseEntity<WorkshopVisitEntity> getRepairById(@PathVariable Long repairId) {
        return workshopVisitService.findRepairById(repairId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/plate/{plateNumber}")
    public ResponseEntity<List<WorkshopVisitEntity>> getRepairsByPlateNumber(@PathVariable String plateNumber) {
        List<WorkshopVisitEntity> repairs = workshopVisitService.listRepairByPlateNumber(plateNumber);
        return ResponseEntity.ok(repairs);
    }

    @PostMapping
    public ResponseEntity<WorkshopVisitEntity> saveRepair(@RequestBody WorkshopVisitEntity repair) {
        WorkshopVisitEntity newRepair = workshopVisitService.saveRepair(repair);
        return ResponseEntity.ok(newRepair);
    }

    @GetMapping("/{repairId}/details")
    public ResponseEntity<List<RepairDetailEntity>> getRepairDetails(@PathVariable Long repairId) {
        if (workshopVisitService.findRepairById(repairId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<RepairDetailEntity> repairDetails = repairDetailService.listRepairByRepairId(repairId);
        return ResponseEntity.ok(repairDetails);
    }

    @PostMapping("/{repairId}/details")
    public ResponseEntity<RepairDetailEntity> saveRepairDetail(
            @PathVariable Long repairId,
            @RequestBody RepairDetailEntity repairDetail
    ) {
        if (workshopVisitService.findRepairById(repairId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        repairDetail.setRepairId(repairId);
        RepairDetailEntity newRepairDetail = repairDetailService.saveRepair(repairDetail);
        return ResponseEntity.ok(newRepairDetail);
    }
}
