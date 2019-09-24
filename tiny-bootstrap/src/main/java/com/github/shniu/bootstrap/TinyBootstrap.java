package com.github.shniu.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author shniu
 * @date 2019/09/24 18:36:05
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({
    "com.github.shniu"
})
@Slf4j
public class TinyBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(TinyBootstrap.class, args);
        log.info("TinyBootstrap startup succeed!");
    }
}
