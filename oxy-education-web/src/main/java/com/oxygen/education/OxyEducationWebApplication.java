package com.oxygen.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author oxy
 */
@EnableAsync
@SpringBootApplication
public class OxyEducationWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(OxyEducationWebApplication.class, args);
    }
}
