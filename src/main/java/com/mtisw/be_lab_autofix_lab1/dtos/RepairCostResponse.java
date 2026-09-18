package com.mtisw.be_lab_autofix_lab1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepairCostResponse {
    private Long repairId;
    private BigDecimal repairsSubtotal;
    private BigDecimal repairCountDiscount;
    private BigDecimal attentionDayDiscount;
    private BigDecimal bonusDiscount;
    private BigDecimal totalDiscounts;
    private BigDecimal mileageSurcharge;
    private BigDecimal vehicleAgeSurcharge;
    private BigDecimal pickupDelaySurcharge;
    private BigDecimal totalSurcharges;
    private BigDecimal iva;
    private BigDecimal totalCost;

}
