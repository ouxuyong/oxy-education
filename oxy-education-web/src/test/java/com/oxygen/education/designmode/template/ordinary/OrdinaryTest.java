package com.oxygen.education.designmode.template.ordinary;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class OrdinaryTest {

    @Test
    public void test(){

        Programmer programmer = new Programmer();
        programmer.wakeUp();
        programmer.behavior();
        programmer.sleep();

        System.out.println("============================================================");

        Doctor doctor = new Doctor();
        doctor.wakeUp();
        doctor.behavior();
        doctor.sleep();
    }
}
