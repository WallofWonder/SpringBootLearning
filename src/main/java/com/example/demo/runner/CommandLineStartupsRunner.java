package com.example.demo.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class CommandLineStartupsRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner传入参数：{}", Arrays.toString(args));
    }
}
