package com.mtisw.be_lab_autofix_lab1.entities;

import com.mtisw.be_lab_autofix_lab1.enums.RepairType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "repairs_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Long repairId;

    @Enumerated(EnumType.STRING)
    private RepairType repairType;

    private BigDecimal repairCost;

}
