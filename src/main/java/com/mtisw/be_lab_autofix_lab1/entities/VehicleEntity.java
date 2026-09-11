package com.mtisw.be_lab_autofix_lab1.entities;

import com.mtisw.be_lab_autofix_lab1.enums.EngineType;
import com.mtisw.be_lab_autofix_lab1.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity 
@Table(name = "vehicles")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class VehicleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String plateNumber;

    private String brand;

    private String model;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private Integer manufacturingYear;

    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    private Integer numberOfSeats;

}
