package com.example.demo;

import com.example.demo.customlistener.MyListener1;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = {"com.example.demo.generator"})
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        context.addApplicationListener(new MyListener1());
    }

}
