package com.oxygen.education.designmode.observer;

import org.junit.Test;

public class ObserverTest {
    @Test
    public void test1() {
        Uploader uploader = new Uploader();
        Observer observer1 = new FansObserver("光头强");
        Observer observer2 = new FansObserver("熊大");
        Observer observer3 = new FansObserver("ikun");
        //todo 关注小欧
        uploader.addObserver(observer1);
        uploader.addObserver(observer2);
        uploader.addObserver(observer3);
        //todo 小欧发布视频
        uploader.sendMessage("小欧发布关于“鸡你太美”视频");
    }

    @Test
    public void test2() {
        Uploader uploader = new Uploader();
        Observer observer1 = new FansObserver("光头强");
        Observer observer2 = new FansObserver("熊大");
        Observer observer3 = new FansObserver("ikun");
        uploader.addObserver(observer1);
        uploader.addObserver(observer2);
        uploader.addObserver(observer3);
        uploader.sendMessage("小欧发布关于“鸡你太美”视频");

        System.out.println("============ikun取关后==================");
        uploader.removeObserver(observer3);
        uploader.sendMessage("小欧发布设计模式视频");
    }
}
