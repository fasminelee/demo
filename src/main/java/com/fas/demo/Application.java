package com.fas.demo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.fas.demo.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " server started!");
        log.info("RabbitMQ: http://localhost:15672/");
        log.info("swagger2: http://127.0.0.1:8080/swagger-ui.html");
    }

}
