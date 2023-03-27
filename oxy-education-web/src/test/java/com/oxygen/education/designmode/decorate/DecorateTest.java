package com.oxygen.education.designmode.decorate;

import com.oxygen.education.designmode.decorate.beverages.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DecorateTest {

//    @Test
//    public void test(){
//        Role role1 = new BasketballPlayer();
//        System.out.println("角色："+role1.roleName() + ", 能力："+role1.skill() + ", 能力值："+role1.ability());
//
//        Role role2 = new Singer();
//        System.out.println("角色："+role2.roleName() + ", 能力："+role2.skill() + ", 能力值："+role2.ability());
//
//        Role role3 = new Ikun();
//        System.out.println("角色："+role3.roleName() + ", 能力："+role3.skill() + ", 能力值："+role3.ability());
//
//    }





    @Test
    public void test1(){
        MilkTea boBoMilkTea = new BoBoMilkTea();
        System.out.println("饮料名称: "+boBoMilkTea.getDescription() + "     价格："+boBoMilkTea.cost());

        MilkTea herbalJelly = new HerbalJelly();
        System.out.println("饮料名称: "+herbalJelly.getDescription() + "     价格："+herbalJelly.cost());

    }



    @Test
    public void test2(){
        MilkTea boBoMilkTea = new BoBoMilkTea();
        boBoMilkTea = new Pearl(boBoMilkTea);
        boBoMilkTea = new Coconut(boBoMilkTea);

        System.out.println("饮料名称: "+boBoMilkTea.getDescription() + "     价格："+boBoMilkTea.cost());


        MilkTea herbalJelly = new HerbalJelly();

        herbalJelly = new Pearl(herbalJelly);
        herbalJelly = new Coconut(herbalJelly);
        herbalJelly = new Ormosia(herbalJelly);
        System.out.println("饮料名称: "+herbalJelly.getDescription() + "     价格："+herbalJelly.cost());

    }






















}
