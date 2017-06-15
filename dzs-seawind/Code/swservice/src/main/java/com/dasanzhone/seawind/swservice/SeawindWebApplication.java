package com.dasanzhone.seawind.swservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dasanzhone.seawind.swservice")
public class SeawindWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeawindWebApplication.class, args);
    }
}
