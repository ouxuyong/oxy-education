package com.oxygen.education.reflect;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    /**
     * 反射整体demo
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        //todo 第一步 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.reflect.User");
        //todo 第二步 调用构造器，获取对象实例
        Object o = clazz.newInstance();
        // todo 第三步 获取类的方法
        Method setUserId = clazz.getMethod("setUserId", Long.class);
        Method getUserId = clazz.getMethod("getUserId");
        // todo 执行方法
        setUserId.invoke(o,100L);
        System.out.println("getUserId 方法执行的结果："+getUserId.invoke(o));

    }

    /**
     *  反射获取构造器列表
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.reflect.User");
        //todo 获取构造器列表
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println("构造器列表:");
        for(Constructor constructor:constructors){
            System.out.println(constructor);
        }

    }

    /**
     * 反射获取指定构造器
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.reflect.User");

        //todo 获取指定构造器
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, String.class);
        System.out.println("输出指定构造器：" + declaredConstructor);

    }

    /**
     * 反射 执行指定构造器
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.reflect.User");

        //todo 获取指定构造器
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, String.class);
        System.out.println("输出指定构造器：" + declaredConstructor);

        System.out.println("===============================================================");
        //todo 执行指定构造器
        Object user = declaredConstructor.newInstance("高启强", "演员");
        System.out.println("输出指定构造器创建的对象：" + user);

    }

    /**
     * 反射获取全部成员变量
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.reflect.User");

        System.out.println("===============================================================");
        //todo 获取全部成员变量
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println("输出成员变量列表：");
        for(Field field : declaredFields){
            System.out.println(field.getName());
        }
    }

    /**
     *  开启私有变量的操作权限，并给私有成员变量赋值
     * @throws Exception
     */
    @Test
    public void test6() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.reflect.User");
        Object user = clazz.newInstance();

        System.out.println("===============================================================");
        //todo 获取指定私有成员变量
        Field name = clazz.getDeclaredField("name");
        System.out.println("指定字段："+name.getName());
        //todo 开启私有变量的操作权限，并给私有成员变量赋值
        name.setAccessible(true);
        name.set(user,"小欧说编程");
        System.out.println("name的值："+name.get(user));
    }

    /**
     *  反射获取方法列表
     * @throws Exception
     */
    @Test
    public void test7() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.reflect.User");
        Object user = clazz.newInstance();

        System.out.println("===============================================================");
        //todo 获取方法列表
        Method[] methods = clazz.getMethods();
        System.out.println("输出方法列表：");
        for(Method method : methods){
            System.out.println(method);
        }
    }


    /**
     * 反射 执行指定方法
     * @throws Exception
     */
    @Test
    public void test8() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.reflect.User");
        Object user = clazz.newInstance();

        System.out.println("===============================================================");
        //todo 获取方法列表
        Method setName = clazz.getMethod("setName", String.class);
        //todo 执行方法 设置name的值
        setName.invoke(user,"高启强");

        Method getName = clazz.getMethod("getName");
        System.out.println("调用指定方法输出结果："+getName.invoke(user));

    }

    @Test
    public void test9() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.reflect.User");
        Object user = clazz.newInstance();

        System.out.println("===============================================================");
        //todo 获取方法列表
        Method setName = clazz.getMethod("setName");
        setName.invoke(user);

    }
}

@Data
class User {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 名字
     */
    private String name;
    /**
     * 职业
     */
    private String occupation;

    public User() {

    }

    public User(String name, String occupation) {
        this.name = name;
        this.occupation = occupation;
    }

    public User(Long userId, String name, String occupation) {
        this.userId = userId;
        this.name = name;
        this.occupation = occupation;
    }
}