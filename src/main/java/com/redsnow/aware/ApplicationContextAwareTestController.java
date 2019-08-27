package com.redsnow.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

/**
 * @author lee
 */
public class ApplicationContextAwareTestController implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        /**
         * 维护了整个程序运行期间所需要的上下文信息
         * 环境 web等等
         */
        Environment environment = applicationContext.getEnvironment();
        BeanFactory factory = applicationContext.getParentBeanFactory();

        environment.getProperty("spring.application.name");
        factory.getBean("beanNameAwareTestController", BeanNameAwareTestController.class);
    }
}
