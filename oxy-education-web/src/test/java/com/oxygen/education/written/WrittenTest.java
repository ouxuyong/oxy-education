package com.oxygen.education.written;

import org.junit.Test;

public class WrittenTest {
    /**
     * 360笔试题
     * 单选题
     *
     * 选项
     * A: 1,2,2
     * B:1,2,3
     * C:1,3,3
     * D:1,3,2
     */
    @Test
    public void writtenTest1(){
        System.out.println(getTemp());
    }

    public Integer getTemp(){
        int temp = 1;
        try {
            //todo 抛异常
            int i= 1/0;
            System.out.println(temp);
            ++ temp;
            return temp;
        }catch (Exception e){
            System.out.println(temp);
            temp +=2;
            return temp;
        }finally {
            ++temp;
            System.out.println(temp);
            return temp;
        }
    }
}
