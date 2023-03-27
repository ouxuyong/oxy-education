package com.oxygen.education.designmode.factory.abstractfactory.factory;

import com.oxygen.education.designmode.factory.abstractfactory.*;

// TCL电器工厂类
public class TclelectricalApplianceFactory  implements ElectricalApplianceFactory {
    /**
     * 创建TCL冰箱
     * @return
     */
    @Override
    public ElectricalAppliance createRefrigerator() {
        return new TclErRefrigerator();
    }

    /**
     * 创建TCL空调
     * @return
     */
    @Override
    public ElectricalAppliance createAirConditioner() {
        return new TclAirConditioner();
    }

    /**
     * 创建TCL电视
     * @return
     */
    @Override
    public ElectricalAppliance createTelevision() {
        return new TclTelevision();
    }
}
