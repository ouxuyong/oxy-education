package com.oxygen.education.designmode.factory.factorymethod;

import com.oxygen.education.designmode.factory.staticfactory.Robot;
import com.oxygen.education.designmode.factory.staticfactory.Toy;

// 定义机器人玩具工厂类
public class RobotFactory implements ToyFactoryInterface {
    public Toy createToy() {
        return new Robot(); // 创建机器人玩具对象
    }
}
