package com.mavis;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mavis.mapper")
public class ScoreManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScoreManagerApplication.class, args);
    }

}
