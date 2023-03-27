package com.oxygen.education;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class MapTest {




























    @Test
    public void test2() {
        User user = new User("高启强", "卖鱼的");
        //学习孙子兵法
        study(user);
        System.out.println(user);
    }

    /**
     * 学习孙子兵法
     *
     * @param user
     */
    public void study(User user) {
        System.out.println(user.getName() + "学习了孙子兵法");
        user.setOccupation("强盛集团董事长");
    }


    @Test
    public void test3() {
        User user = new User("高启强", "卖鱼的");
        //学习孙子兵法
        User newUser = study2(user);

        System.out.println("学习孙子兵法前：" + user);
        System.out.println("学习孙子兵法后：" + newUser);
    }

    /**
     * 学习孙子兵法
     *
     * @param user
     */
    public User study2(User user) {
        System.out.println(user.getName() + "学习了孙子兵法");
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setOccupation("强盛集团董事长");
        return newUser;
    }


    @Test
    public void test4() {
        List<String> userList = Arrays.asList("高启强", "高启盛", "唐小龙", "唐小虎");
        enhance(userList);
        userList.forEach(user -> System.out.println(user));
    }

    /**
     * 壮大强盛集团
     *
     * @param userList
     */
    public void enhance(List<String> userList) {
        System.out.println("强盛集团F5缺少老默怎么行，必须加上");

//        userList.add("老默");
        userList.set(3, "老默");
    }


    /**
     * 打印 main方法的入参
     *
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        for (String str : args) {
            System.out.println(str);
        }
        //1)加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2)DriverManager获取数据库链接  int a = func(......);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oxy_education?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC&&autoReconnect=true&failOverReadOnly=false", "root", "123456");
        //3)通过链接，创建statement
        Statement stat = conn.createStatement();
        // 4)执行SQL，获取结果集
        // 增、删、改  对表进行update操作
        // 查  对表进行查询操作 query     Resultset
        ResultSet rs = stat.executeQuery("select * from user");
        while (rs.next()) {
            System.out.println(rs.getString("phone"));
        }
        // 5)关闭链接
        rs.close();
        stat.close();
        conn.close();
    }


    @Test
    public void test5() {

        User user = new User("张颂文", "演员");
        Map map = new HashMap();
        map.put("key1", "测试");
        map.put("user1", user);
        map.put("user2", user);

        System.out.println(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect));

    }

    public List<User> getUserList() {
        List<User> list = new ArrayList<>();
        list.add(new User(1L, "张颂文", "演员"));
        list.add(new User(2L, "张译", "演员"));
        list.add(new User(3L, "刘德华", "演员"));
        list.add(new User(4L, "小沈阳", "小品演员"));
        list.add(new User(5L, "黄家驹", "歌手"));
        list.add(new User(6L, "成龙", "演员"));
        list.add(new User(7L, "高叶", "演员"));
        list.add(new User(8L, "李连杰", "演员"));
        list.add(new User(9L, "小欧", "码农"));
        return list;
    }


    @Test
    public void test6() {
        //获取用户id列表
        List<User> userList = getUserList();
        List<Long> ids = new ArrayList<>(userList.size());
        for (User user : userList) {
            if (user == null || user.getUserId() == null) {
                continue;
            }
            ids.add(user.getUserId());
        }
        System.out.println("输出ids 结果：" + ids);
    }


    @Test
    public void test7() {
        //获取用户id列表
        List<User> userList = getUserList();
        List<Long> ids = userList.stream().filter(user -> user != null && user.getUserId() != null)
                .map(User::getUserId).collect(Collectors.toList());

        System.out.println("输出ids 结果：" + ids);
    }


    @Test
    public void test8() {
        Integer sum = sum(3, 5);
        System.out.println("sum = " + sum);
    }


    public Integer sum(Integer a, Integer b) {
        return a + b;
    }


    @Test
    public void test18() {
        List<String> list = Arrays.asList(404 + "", 502 + "", 503 + "", 1024 + "");
        //todo 第一种 toArray()
        String[] array1 = (String[]) list.toArray();
        System.out.println(print(array1));

//        //todo 第二种 toArray(T[] a)
//        Integer[] array2 = list.toArray(new Integer[list.size()]);
//        System.out.println(print(array2));
//
//        //todo 第三种 循环赋值
//        Integer[] array3 = new Integer[list.size()];
//        for(int i =0;i<list.size();i++){
//            array3[i] = list.get(i);
//        }
//        System.out.println(print(array3));
    }

    private String print(Object[] array) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Object num : array) {
            stringBuilder.append(" ");
            stringBuilder.append(num);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    @Test
    public void test19() throws Exception {
        //todo 第一步 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.User");
        //todo 第二步 调用构造器，获取对象实例
        Object o = clazz.newInstance();
        // todo 第三步 获取类的方法
        Method setUserId = clazz.getMethod("setUserId", Long.class);
        Method getUserId = clazz.getMethod("getUserId");
        // todo 执行方法
        setUserId.invoke(o,100L);
        System.out.println("getUserId 方法执行的结果："+getUserId.invoke(o));

    }

    @Test
    public void test20() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.User");
        //todo 获取构造器列表
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println("构造器列表:");
        for(Constructor constructor:constructors){
            System.out.println(constructor);
        }

    }

    @Test
    public void test21() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.User");

        //todo 获取指定构造器
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, String.class);
        System.out.println("输出指定构造器：" + declaredConstructor);

    }

    @Test
    public void test22() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.User");

        //todo 获取指定构造器
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, String.class);
        System.out.println("输出指定构造器：" + declaredConstructor);

        System.out.println("===============================================================");
        //todo 执行指定构造器
        Object user = declaredConstructor.newInstance("高启强", "演员");
        System.out.println("输出指定构造器创建的对象：" + user);

    }

    @Test
    public void test23() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.User");

        System.out.println("===============================================================");
        //todo 获取全部成员变量
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println("输出成员变量列表：");
        for(Field field : declaredFields){
            System.out.println(field.getName());
        }
    }

    @Test
    public void test24() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.User");
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

    @Test
    public void test25() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.User");
        Object user = clazz.newInstance();

        System.out.println("===============================================================");
        //todo 获取方法列表
        Method[] methods = clazz.getMethods();
        System.out.println("输出方法列表：");
        for(Method method : methods){
            System.out.println(method);
        }
    }

    @Test
    public void test26() throws Exception {
        //todo 获取类的Class对象
        Class<?> clazz = Class.forName("com.oxygen.education.User");
        Object user = clazz.newInstance();

        System.out.println("===============================================================");
        //todo 获取方法列表
        Method setName = clazz.getMethod("setName", String.class);
        //设置name的值
        setName.invoke(user,"高启强");

        Method getName = clazz.getMethod("getName", String.class);
        System.out.println("调用指定方法输出结果："+getName);

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
