package com.oxygen.education.designmode.factory.abstractfactory.factory;

import com.oxygen.education.designmode.factory.abstractfactory.*;

// 海尔电器工厂类
public class HaierElectricalApplianceFactory implements ElectricalApplianceFactory {
    /**
     * 创建海尔冰箱
     * @return
     */
    @Override
    public ElectricalAppliance createRefrigerator() {
        return new HaiErRefrigerator();
    }
    /**
     * 创建海尔空调
     * @return
     */
    @Override
    public ElectricalAppliance createAirConditioner() {
        return new HaiErAirConditioner();
    }

    /**
     * 创建海尔电视
     * @return
     */
    @Override
    public ElectricalAppliance createTelevision() {
        return new HaiErTelevision();
    }
}
