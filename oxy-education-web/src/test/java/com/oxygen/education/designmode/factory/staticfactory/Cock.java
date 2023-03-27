package com.oxygen.education.designmode.factory.staticfactory;
// 定义公鸡玩具类
public class Cock implements Toy{
    @Override
    public void play() {
        System.out.println("你干嘛！！！！！"); // 打印玩公鸡玩具的操作
    }
}
