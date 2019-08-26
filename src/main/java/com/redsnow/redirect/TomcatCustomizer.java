package com.redsnow.redirect;

import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc 代码的方式配置servlet容器（tomcat等） 注册实现 EmbeddedServletContainerCustomizer
 *        重写 customize(ConfigurableEmbeddedServletContainer container)
 * @author lee
 */
@Configuration
@SuppressWarnings("all")
public class TomcatCustomizer{
    /**
     * ConfigurableWebServerFactory 通用的设置
     * 采用监听器 可以结合配置文件动态的修改优化配置
     *
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableTomcatWebServerFactory> webServerFactoryCustomizer(){
       return new WebServerFactoryCustomizer<ConfigurableTomcatWebServerFactory>() {
           @Override
           public void customize(ConfigurableTomcatWebServerFactory factory) {
               factory.setPort(8082);
           }
       };
    }
}
