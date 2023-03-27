package com.oxygen.education;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput) // 吞吐量
@OutputTimeUnit(TimeUnit.MILLISECONDS) // 结果所使用的时间单位
@State(Scope.Thread) // 每个测试线程分配一个实例
@Fork(1) // Fork进行的数目
@Warmup(iterations = 4) // 先预热4轮
@Measurement(iterations = 5) //测试的次数
public class NumAddTest {


    /**
     * 循环 10000次 i = i+1
     */
    @Benchmark
    public int commonAdd() {
        int i = 0;
        i = i+ 1;
        for(int k = 0;k<10000;k++){
            i = i+ 1;
        }
       return i;
    }

    /**
     * 循环 10000次 i+=1
     */
    @Benchmark
    public int especiallyAdd() {
        int i = 0;
        for(int k = 0;k<10000;k++){
            i += 1;
        }
        return i;
    }

    /**
     * 启动方法
     * @param args
     * @throws RunnerException
     */
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(NumAddTest.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
