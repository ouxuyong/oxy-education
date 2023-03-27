package com.oxygen.education.optional;

import org.junit.Test;

import java.util.Base64;
import java.util.Optional;

public class OptionalTest {

    @Test
    public void optionalTest1(){

        Optional<Object> optional = Optional.ofNullable(null);
        System.out.println(optional);
        String trd = new String("6666");
        trd.toString();
    }
    @Test
    public void test(){
        String str ="我是小欧";
        String string = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println(string);

        byte[] bytes = Base64.getDecoder().decode(string);
        String str1 = new String(bytes);
        System.out.println(str1);
    }
}
