package com.mtisw.be_lab_autofix_lab1.services;

import com.mtisw.be_lab_autofix_lab1.enums.EngineType;
import com.mtisw.be_lab_autofix_lab1.enums.RepairType;
import org.springframework.stereotype.Service;

@Service
public class RepairPriceService {
    int getRepairCost(RepairType repairType, EngineType engineType) {
        return switch (repairType) {
            case BRAKE_SYSTEM -> switch (engineType) {
                case GASOLINE, DIESEL -> 120000;
                case HYBRID -> 180000;
                case ELECTRIC -> 220000;
            };

            case COOLING_SYSTEM -> switch (engineType) {
                case GASOLINE, DIESEL -> 130000;
                case HYBRID -> 190000;
                case ELECTRIC -> 230000;
            };

            case ENGINE -> switch (engineType) {
                case GASOLINE -> 350000;
                case DIESEL -> 450000;
                case HYBRID -> 700000;
                case ELECTRIC -> 800000;
            };

            case TRANSMISSION -> switch (engineType) {
                case GASOLINE, DIESEL -> 210000;
                case HYBRID, ELECTRIC -> 300000;
            };

            case ELECTRICAL_SYSTEM -> switch (engineType) {
                case GASOLINE, DIESEL -> 150000;
                case HYBRID -> 200000;
                case ELECTRIC -> 250000;
            };

            case EXHAUST_SYSTEM -> switch (engineType) {
                case GASOLINE -> 100000;
                case DIESEL -> 120000;
                case HYBRID -> 450000;
                case ELECTRIC -> 0;
            };

            case TIRES_AND_WHEELS -> 100000;

            case SUSPENSION_AND_STEERING -> switch (engineType) {
                case GASOLINE, DIESEL -> 180000;
                case HYBRID -> 210000;
                case ELECTRIC -> 250000;
            };

            case AIR_CONDITIONING_AND_HEATING -> switch (engineType) {
                case GASOLINE, DIESEL -> 150000;
                case HYBRID, ELECTRIC -> 180000;
            };

            case FUEL_SYSTEM -> switch (engineType) {
                case GASOLINE -> 130000;
                case DIESEL -> 140000;
                case HYBRID -> 220000;
                case ELECTRIC -> 0;
            };

            case WINDSHIELD_AND_GLASS -> 80000;
        };
    }
}
