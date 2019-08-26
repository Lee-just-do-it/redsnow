package com.redsnow.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

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
@EnableConfigurationProperties(StartAutoConfiguration.class)
@ConditionalOnClass(StartAutoService.class)
@ConditionalOnProperty(prefix = "start", value = "enabled", matchIfMissing = true)
@SuppressWarnings("all")
public class StartAutoConfiguration {

    @Autowired
    private StartAutoService startAutoService;

    @Bean
    @ConditionalOnBean(StartAutoService.class)
    public StartAutoService startAutoService() {
        StartAutoService autoService = new StartAutoService();
        autoService.set(startAutoService.get());
        return autoService;
    }
}
