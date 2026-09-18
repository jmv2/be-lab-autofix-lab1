package com.mtisw.be_lab_autofix_lab1.controllers;

import com.mtisw.be_lab_autofix_lab1.dtos.RepairCostResponse;
import com.mtisw.be_lab_autofix_lab1.entities.RepairDetailEntity;
import com.mtisw.be_lab_autofix_lab1.entities.WorkshopVisitEntity;
import com.mtisw.be_lab_autofix_lab1.services.RepairCostService;
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
    private final RepairCostService repairCostService;

    public RepairController(
            WorkshopVisitService workshopVisitService,
            RepairDetailService repairDetailService,
            RepairCostService repairCostService) {

        this.workshopVisitService = workshopVisitService;
        this.repairDetailService = repairDetailService;
        this.repairCostService = repairCostService;
    }

    // todas las reparaciones
    @GetMapping
    public ResponseEntity<List<WorkshopVisitEntity>> listAllRepairs() {
        List<WorkshopVisitEntity> repairs = workshopVisitService.listAllRepairs();
        return ResponseEntity.ok(repairs);
    }

    // una repa por id
    @GetMapping("/{repairId}")
    public ResponseEntity<WorkshopVisitEntity> getRepairById(@PathVariable Long repairId) {
        return workshopVisitService.findRepairById(repairId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //una repa por patente
    @GetMapping("/plate/{plateNumber}")
    public ResponseEntity<List<WorkshopVisitEntity>> getRepairsByPlateNumber(@PathVariable String plateNumber) {
        List<WorkshopVisitEntity> repairs = workshopVisitService.listRepairByPlateNumber(plateNumber);
        return ResponseEntity.ok(repairs);
    }

    // crea una visita al taller mecanico
    @PostMapping
    public ResponseEntity<WorkshopVisitEntity> saveRepair(@RequestBody WorkshopVisitEntity repair) {
        WorkshopVisitEntity newRepair = workshopVisitService.saveRepair(repair);
        return ResponseEntity.ok(newRepair);
    }

    // trae detalles de una visita al taller
    @GetMapping("/{repairId}/details")
    public ResponseEntity<List<RepairDetailEntity>> getRepairDetails(@PathVariable Long repairId) {
        if (workshopVisitService.findRepairById(repairId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<RepairDetailEntity> repairDetails = repairDetailService.listRepairByRepairId(repairId);
        return ResponseEntity.ok(repairDetails);
    }

    // crea detalles en una visita
    @PostMapping("/{repairId}/details")
    public ResponseEntity<RepairDetailEntity> saveRepairDetail(
            @PathVariable Long repairId,
            @RequestBody RepairDetailEntity repairDetail) {

        if (workshopVisitService.findRepairById(repairId).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        repairDetail.setRepairId(repairId);
        RepairDetailEntity newRepairDetail = repairDetailService.saveRepair(repairDetail);
        return ResponseEntity.ok(newRepairDetail);
    }

    @GetMapping("/{repairId}/costs")
    public ResponseEntity<RepairCostResponse> getRepairCost(@PathVariable Long repairId) {
        try {
            RepairCostResponse repairCost = repairCostService.calculateRepairCost(repairId);
            return ResponseEntity.ok(repairCost);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
