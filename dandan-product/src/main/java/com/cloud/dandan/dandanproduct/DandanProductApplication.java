package com.cloud.dandan.dandanproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.cloud.dandan.dandanproduct.mapper")
@ImportResource("classpath:mapper/*.xml")
public class DandanProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(DandanProductApplication.class, args);
    }

}
