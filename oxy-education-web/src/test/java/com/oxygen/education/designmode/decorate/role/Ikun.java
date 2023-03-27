package com.oxygen.education.designmode.decorate.role;

public class Ikun implements Role{
    @Override
    public String roleName() {
        return "Ikun";
    }

    @Override
    public String skill() {
        return "你干嘛！！！！";
    }

    @Override
    public Integer ability() {
        return 50;
    }
}
