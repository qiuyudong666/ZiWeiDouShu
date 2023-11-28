package com.zwds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.zwds.mapper"})
public class DescriptionApp {
    public static void main(String[] args) {
        SpringApplication.run(DescriptionApp.class,args);
    }
}
