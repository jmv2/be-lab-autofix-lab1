package com.mtisw.be_lab_autofix_lab1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mtisw.be_lab_autofix_lab1.entities.VehicleEntity;
import com.mtisw.be_lab_autofix_lab1.services.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
@CrossOrigin("*")
public class VehicleController {
    @Autowired 
    VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleEntity>> listAllVehicles() {
        List<VehicleEntity> vehicles = vehicleService.listAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping
    public ResponseEntity<VehicleEntity> saveVehicle(@RequestBody VehicleEntity vehicle) {
        VehicleEntity vehicleNew = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok(vehicleNew);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleEntity> getVehicleById(@PathVariable Long id) {
        VehicleEntity vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteVehicleById(@PathVariable Long id) throws Exception {
        var isDeleted = vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
