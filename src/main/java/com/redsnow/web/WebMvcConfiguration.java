package com.redsnow.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @desc 旧版本 WebMvcConfigurerAdapter 标记为@Deprecated
 *       用 WebMvcConfigurationSupport 替换
 *
 *       web相关大的配置，比如 增加拦截器 Interceptor
 * @author lee
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }
}
