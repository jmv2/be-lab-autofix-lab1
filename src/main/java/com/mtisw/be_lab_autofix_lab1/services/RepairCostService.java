package com.mtisw.be_lab_autofix_lab1.services;

import com.mtisw.be_lab_autofix_lab1.dtos.RepairCostResponse;
import com.mtisw.be_lab_autofix_lab1.entities.RepairDetailEntity;
import com.mtisw.be_lab_autofix_lab1.entities.VehicleEntity;
import com.mtisw.be_lab_autofix_lab1.entities.WorkshopVisitEntity;
import com.mtisw.be_lab_autofix_lab1.enums.EngineType;
import com.mtisw.be_lab_autofix_lab1.enums.RepairType;
import com.mtisw.be_lab_autofix_lab1.enums.VehicleType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class RepairCostService {
    private static final BigDecimal IVA_RATE = BigDecimal.valueOf(0.19);
    private static final LocalTime ATTENTION_DISCOUNT_START = LocalTime.of(9, 0);
    private static final LocalTime ATTENTION_DISCOUNT_END = LocalTime.of(12, 0);

    private final RepairDetailService repairDetailService;
    private final WorkshopVisitService workshopVisitService;
    private final VehicleService vehicleService;
    private final RepairPriceService repairPriceService;

    public RepairCostService(
            RepairDetailService repairDetailService,
            WorkshopVisitService workshopVisitService,
            VehicleService vehicleService, RepairPriceService repairPriceService
    ) {
        this.repairDetailService = repairDetailService;
        this.workshopVisitService = workshopVisitService;
        this.vehicleService = vehicleService;
        this.repairPriceService = repairPriceService;
    }

    public RepairCostResponse calculateRepairCost(Long repairId){
        return new RepairCostResponse(
                this.calcTypeRepair(repairId),
                repairsSubtotal,

        );
    }

    private BigDecimal calcTypeRepair(Long repairId){
        Optional<WorkshopVisitEntity> workshopVisit = workshopVisitService.findRepairById(repairId);
        VehicleEntity vehicle = vehicleService.findByPlateNumber(workshopVisit.get().getPlateNumber());

        BigDecimal subtotal = BigDecimal.ZERO;
        List<RepairDetailEntity> repairDetails = repairDetailService.listRepairByRepairId(repairId);

        for (RepairDetailEntity repairDetail : repairDetails) {
            subtotal = subtotal.add(
                    BigDecimal.valueOf(repairPriceService.getRepairCost(
                            repairDetail.getRepairType(),
                            vehicle.getEngineType()
                    ))
            );
        }
        return subtotal;
    }
}
