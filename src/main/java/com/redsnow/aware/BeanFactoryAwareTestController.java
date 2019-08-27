package com.redsnow.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lee
 * @desc BeanFactoryAware 感知容器 创建bean的beanFactory，可以从中获取bean相关的信息
 * 曾经有个面试题：决定bean的初始化加载顺序
 * <p>
 * 在很早以前比较难控制，，就可以通过BeanFactoryAware 获取bean是否存在来延迟加载顺序，
 * 这也增强了 和Spring框架的耦合，毕竟Spring官方不建议使用 框架内部使用的 aware接口
 * <p>
 * 现在解决bean加载顺序的问题就容易多了，，根据条件注解@Conditional @Order @ConditionalOnBean @ConditionalOnClass
 * 甚至实现 conditional接口都是可以延迟bean的加载顺序
 */
@RestController

public class BeanFactoryAwareTestController implements BeanFactoryAware {

    private boolean flag = false;

    @GetMapping("contains")
    public void containsBean() {
        System.out.println(flag);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        flag = beanFactory.containsBean("beanNameAwareTestController");
    }
}
