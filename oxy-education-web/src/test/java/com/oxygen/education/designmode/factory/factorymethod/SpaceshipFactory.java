package com.oxygen.education.designmode.factory.factorymethod;

import com.oxygen.education.designmode.factory.staticfactory.Spaceship;
import com.oxygen.education.designmode.factory.staticfactory.Toy;

// 定义飞船玩具工厂类
public class SpaceshipFactory implements ToyFactoryInterface {
    public Toy createToy() {
        return new Spaceship(); // 创建飞船玩具对象
    }
}
