package com.oxygen.education.designmode.singleton;

import com.oxygen.education.designmode.singleton.Singleton;
import org.junit.Test;

public class DesignModeTest {

    /**
     * 获取单例对象
     */
    @Test
    public void getSingleton(){
        // 获取实例1
        Singleton s1 = Singleton.create();

        //获取实例2
        Singleton s2 = Singleton.create();

        //判断两个实例是否为同一个
        System.out.println(s1 == s2);
    }
}
