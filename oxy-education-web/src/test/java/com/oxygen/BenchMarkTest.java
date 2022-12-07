package com.oxygen;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput) // 吞吐量
@OutputTimeUnit(TimeUnit.MILLISECONDS) // 结果所使用的时间单位
@State(Scope.Thread) // 每个测试线程分配一个实例
@Fork(1) // Fork进行的数目
@Warmup(iterations = 4) // 先预热4轮
@Measurement(iterations = 5) //测试的次数
public class BenchMarkTest {

    @Param({"10", "40", "70", "100"}) // 定义四个参数，之后会分别对这四个参数进行测试
    private int n;

    private List<Integer> arrayList;
    private List<Integer> linkedList;

    /**
     * 初始化方法，在全部Benchmark运行之前进行
     */
    @Setup(Level.Trial)
    public void init() {
        arrayList = new ArrayList<>(0);
        linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    /**
     * arrayList遍历
     */
    @Benchmark
    public void arrayListTraverse() {
        for (int i = 0; i < n; i++) {
            arrayList.get(i);
        }
    }

    /**
     * linkedList遍历
     */
    @Benchmark
    public void linkedListTraverse() {
        for (int i = 0; i < n; i++) {
            linkedList.get(i);
        }
    }

    /**
     * 清空列表
     *  结束方法，在全部Benchmark运行之后进行
     */
    @TearDown(Level.Trial)
    public void arrayRemove() {
        for (int i = 0; i < n; i++) {
            arrayList.remove(0);
            linkedList.remove(0);
        }
    }

    /**
     * 启动方法
     * @param args
     * @throws RunnerException
     */
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(BenchMarkTest.class.getSimpleName()).build();
        new Runner(options).run();
    }
}
