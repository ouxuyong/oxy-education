package com.oxygen.education.designmode.decorate.role;

public class Singer implements Role{
    @Override
    public String roleName() {
        return "歌手";
    }

    @Override
    public String skill() {
        return "唱歌";
    }

    @Override
    public Integer ability() {
        return 150;
    }
}
