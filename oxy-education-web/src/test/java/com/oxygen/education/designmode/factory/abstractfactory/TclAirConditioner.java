package com.oxygen.education.designmode.factory.abstractfactory;

// TCL空调产品类
public class TclAirConditioner implements ElectricalAppliance {
    @Override
    public void turnOn() {
        System.out.println("TCL空调已打开");
    }

    @Override
    public void turnOff() {
        System.out.println("TCL空调已关闭");
    }
}
