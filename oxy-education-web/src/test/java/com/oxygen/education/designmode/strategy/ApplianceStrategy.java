package com.oxygen.education.designmode.strategy;

import com.oxygen.education.designmode.strategy.example.ElectricAppliance;


/**
 * 策略类，用于执行电器操作
 */
public class ApplianceStrategy {
    private ElectricAppliance appliance;

    public ApplianceStrategy(ElectricAppliance appliance) {
        this.appliance = appliance;
    }

    public void use() {
        appliance.turnOn();
        appliance.use();
        appliance.turnOff();
        System.out.println("=============================================");
    }
}