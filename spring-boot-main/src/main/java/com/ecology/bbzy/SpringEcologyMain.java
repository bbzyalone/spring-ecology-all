package com.ecology.bbzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * SpringBootApplication
 */
@SpringBootApplication
@MapperScan("com.ecology.bbzy.mapper")
public class SpringEcologyMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringEcologyMain.class, args);
    }
}
