package com.redsnow.auto;

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
@SuppressWarnings("all")
public class StartAutoService {

    private String name;

    public String get() {
        return name;
    }

    public void set(String args) {
        this.name = args;
    }

}
