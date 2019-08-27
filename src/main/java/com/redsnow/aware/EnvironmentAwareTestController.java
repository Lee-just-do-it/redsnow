package com.redsnow.aware;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lee
 * @desc aware bean自身能够感知xxx。。。 比如：实现 EnvironmentAware 的bean 可以感知应用上下文环境
 * 也可以采用： @Autowired private Environment environment;
 * 或者 @Value  @ConfigurationProperties等读取环境配置信息
 */
@RestController
@SuppressWarnings("all")
public class EnvironmentAwareTestController implements EnvironmentAware {

    private String name;

    @GetMapping("get")
    public String get() {
        return name;
    }

    @Override
    public void setEnvironment(final Environment environment) {
        name = environment.getProperty("spring.application.name");
    }
}
