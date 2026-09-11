package com.mtisw.be_lab_autofix_lab1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtisw.be_lab_autofix_lab1.repositories.VehicleRepository;
import com.mtisw.be_lab_autofix_lab1.entities.VehicleEntity;


@Service 
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public List<VehicleEntity> listAllVehicles(){
        return vehicleRepository.findAll();
    }

    public VehicleEntity saveVehicle(VehicleEntity vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public VehicleEntity getVehicleById(Long id) {
        return vehicleRepository.findById(id).get();
    }

    public boolean deleteVehicle(Long id) throws Exception {
        try{
            vehicleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public VehicleEntity findByPlateNumber(String plateNumber){
        return vehicleRepository.findByPlateNumber(plateNumber);
    }

}
