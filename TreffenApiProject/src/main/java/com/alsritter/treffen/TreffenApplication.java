package com.alsritter.treffen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.alsritter.treffen.mapper")
@SpringBootApplication
public class TreffenApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreffenApplication.class, args);
    }

}
