package com.redsnow.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lee
 * @desc 实现 EnvironmentAware 的bean 可以感知应用上下文环境 注册到spring ioc容器的当前bean的名称 <name>
 */
@RestController
public class BeanNameAwareTestController implements BeanNameAware {

    private String name;

    @GetMapping("get/name")
    public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String s) {
        this.name = s;
    }
}
