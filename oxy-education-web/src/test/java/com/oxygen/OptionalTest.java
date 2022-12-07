package com.oxygen;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void optionalTest1(){

        Optional<Object> optional = Optional.ofNullable(null);
        System.out.println(optional);
        String trd = new String("6666");
        trd.toString();
    }
}
