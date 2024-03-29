package com.oxygen.education.designmode.observer;

/**
 * 粉丝观察者
 */
public class FansObserver implements Observer {
    private String name;

    public FansObserver(String name) {
        this.name = name;
    }

    /**
     * 接收消息
     * @param message
     */
    @Override
    public void receive(String message) {
        System.out.println(name + " 收到消息: " + message);
    }
}