package com.dasol.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan : configure the package to search and register beans in.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
