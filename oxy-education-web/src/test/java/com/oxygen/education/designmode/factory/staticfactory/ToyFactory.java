package com.oxygen.education.designmode.factory.staticfactory;

// 定义玩具工厂类
public class ToyFactory {
    // 静态方法创建不同类型的玩具对象
    public static Toy createToy(String type) {
        if (type.equalsIgnoreCase("robot")) {
            return new Robot(); // 创建机器人玩具对象
        } else if (type.equalsIgnoreCase("spaceship")) {
            return new Spaceship(); // 创建飞船玩具对象
        } else if (type.equalsIgnoreCase("dinosaur")) {
            return new Dinosaur(); // 创建恐龙玩具对象
        }else if (type.equalsIgnoreCase("cock")) {
            return new Cock(); // 创建公鸡玩具对象
        } else {
            return null; // 返回空对象
        }
    }
}
