package com.redsnow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author lee
 */
@SuppressWarnings("all")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RedsnowApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedsnowApplication.class, args);
    }

}
