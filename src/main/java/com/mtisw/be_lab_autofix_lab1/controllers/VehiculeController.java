package com.mtisw.be_lab_autofix_lab1.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/vehicule")
@CrossOrigin("*")
public class VehiculeController {
    
    @GetMapping("")
    public String getVehicules() {
        return "Todos los vehiculos del mundo";
    }
    
}
