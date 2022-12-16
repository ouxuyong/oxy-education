package com.oxygen.education;

import org.junit.Test;

public class ToStringTest {
    @Test
    public void toStringPrintln(){
        Dog dog = new Dog();
        dog.setId(1);
        dog.setName("旺财");

        System.out.println(dog);
    }
}

class Dog {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
