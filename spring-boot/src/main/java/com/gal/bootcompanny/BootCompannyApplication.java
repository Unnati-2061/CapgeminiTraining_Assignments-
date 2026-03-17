package com.gal.bootcompanny;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootCompannyApplication {
//    private static LoggerContext loggerFactory;
    public static final Logger log = LoggerFactory.getLogger(BootCompannyApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(BootCompannyApplication.class, args);
        ConfigurableApplicationContext context  = SpringApplication.run(BootCompannyApplication.class);

        log.info("Application started successfully");
    }

}
