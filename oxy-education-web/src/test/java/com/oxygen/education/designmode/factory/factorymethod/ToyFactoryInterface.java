package com.oxygen.education.designmode.factory.factorymethod;

import com.oxygen.education.designmode.factory.staticfactory.Toy;

// 定义玩具工厂接口
public interface ToyFactoryInterface {
    Toy createToy(); // 定义创建玩具的方法
}