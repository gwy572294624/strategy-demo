package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StrategyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrategyDemoApplication.class, args);
    }

}
