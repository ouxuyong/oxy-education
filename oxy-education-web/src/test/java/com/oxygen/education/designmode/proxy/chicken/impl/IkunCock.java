package com.oxygen.education.designmode.proxy.chicken.impl;

import com.oxygen.education.designmode.proxy.chicken.Chicken;

public class IkunCock implements Chicken {



    @Override
    public void call() {
        System.out.println("你干嘛！！！！！！");
    }

    @Override
    public void behavior() {
        System.out.println("唱、跳、rap、篮球");
    }
}
