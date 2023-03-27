package com.oxygen.education.designmode.factory.factorymethod;

import com.oxygen.education.designmode.factory.staticfactory.Dinosaur;
import com.oxygen.education.designmode.factory.staticfactory.Toy;

// 定义恐龙玩具工厂类
public class DinosaurFactory implements ToyFactoryInterface {
    public Toy createToy() {
        return new Dinosaur(); // 创建恐龙玩具对象
    }
}
