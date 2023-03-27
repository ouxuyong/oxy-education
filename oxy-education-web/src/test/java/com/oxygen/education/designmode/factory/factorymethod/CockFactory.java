package com.oxygen.education.designmode.factory.factorymethod;

import com.oxygen.education.designmode.factory.staticfactory.Cock;
import com.oxygen.education.designmode.factory.staticfactory.Toy;

public class CockFactory implements ToyFactoryInterface {
    public Toy createToy() {
        return new Cock(); // 创建公鸡玩具对象
    }
}
