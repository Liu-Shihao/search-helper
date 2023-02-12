package com.lsh.opennlp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: LiuShihao
 * @Date: 2023/2/12 20:47
 * @Desc:
 */
@Slf4j
@SpringBootApplication
public class OpenNLPApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenNLPApplication.class,args);
        log.info("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        log.info("* * * * * * * * * * * * * * * My SearchHelper Is Start Up!* * * * * * * * * ");
        log.info("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
    }
}
