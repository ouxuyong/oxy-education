package com.oxygen;

import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @author oxy
 * 运行时间测试类
 */
public class RunTimeTest {

    /**
     * 统计耗时时间
     */
    @Test
    public void oldStatisticsTime() throws InterruptedException {

        //todo 模拟保存用户
        long startTime1 = System.currentTimeMillis();
        saveUser();
        System.out.println("保存用户耗时 = " + (System.currentTimeMillis() - startTime1) + "ms");

        //todo 模拟保存商品
        long startTime2 = System.currentTimeMillis();
        saveGoods();
        System.out.println("保存商品耗时 = " + (System.currentTimeMillis() - startTime2) + "ms");

        //todo 模拟保存订单
        long startTime3 = System.currentTimeMillis();
        saveOrder();
        System.out.println("保存订单耗时 = " + (System.currentTimeMillis() - startTime3) + "ms");

    }




    /**
     * 统计耗时时间
     */
    @Test
    public void newStatisticsTime() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        //todo 模拟保存用户
        stopWatch.start("保存用户");
        saveUser();
        stopWatch.stop();


        //todo 模拟保存商品
        stopWatch.start("保存商品");
        saveGoods();
        stopWatch.stop();

        //todo 模拟保存订单
        stopWatch.start("保存订单");
        saveOrder();
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
        System.out.println("总耗时："+ stopWatch.getTotalTimeMillis() + "ms");

    }



    private void saveOrder() throws InterruptedException {
        //todo 查询订单
        Thread.sleep(400);
    }


    private void saveGoods() throws InterruptedException {
        //todo 查询商品
        Thread.sleep(300);
    }


    private void saveUser() throws InterruptedException {
        //todo 查询用户
        Thread.sleep(300);
    }
}

