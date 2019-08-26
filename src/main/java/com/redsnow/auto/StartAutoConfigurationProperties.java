package com.redsnow.auto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lee
 * @desc 自定义可引用的 start pom
 * <dependency>
 * <groupId>com.redsnow.auto</groupId>
 * <artifactId>spring-boot-start-pom</artifactId>
 * <version>0.0.1-SNAPSHOT</version>
 * </dependency>
 * @see 'classspath:resources/META_INF/spring-factories.properties'
 */
@Component
@ConfigurationProperties(prefix = "start", ignoreInvalidFields = true)
@Data
@SuppressWarnings("all")
public class StartAutoConfigurationProperties {
    private String name;
}
