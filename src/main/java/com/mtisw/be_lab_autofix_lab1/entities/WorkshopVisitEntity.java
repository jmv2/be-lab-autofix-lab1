package com.mtisw.be_lab_autofix_lab1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "repairs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkshopVisitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String plateNumber;

    private LocalDate workshopEntryDate;
    private LocalTime workshopEntryTime;

    private LocalDate repairCompletionDate;
    private LocalTime repairCompletionTime;

    private LocalDate vehiclePickupDate;
    private LocalTime vehiclePickupTime;

    private Integer mileage;

}
