package com.redsnow.aware;

import org.springframework.beans.factory.InitializingBean;


/**
 * @author lee
 */
public class InitializingBeanTestController implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init bean do somethings");
    }
}
