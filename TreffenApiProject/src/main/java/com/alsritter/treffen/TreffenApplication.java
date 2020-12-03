package com.alsritter.treffen;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableKnife4j
@EnableOpenApi
@MapperScan("com.alsritter.treffen.mapper")
@SpringBootApplication
public class TreffenApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreffenApplication.class, args);
    }

}
