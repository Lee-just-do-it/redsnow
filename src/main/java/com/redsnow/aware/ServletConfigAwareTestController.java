package com.redsnow.aware;

import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.SessionCookieConfig;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author lee
 */
public class ServletConfigAwareTestController implements ServletConfigAware, ServletContextAware {
    @Override
    public void setServletConfig(ServletConfig servletConfig) {
        /**
         * servletConfig是针对servlet而言的，每个servlet都有它独有的servletConfig信息，相互之间不共享
         */
        ServletContext servletContext = servletConfig.getServletContext();
        try {
            URL resource = servletContext.getResource("classpath:resources/application.properties");
            InputStream stream = servletContext.getResourceAsStream("classpath:resources/application.properties");
            Properties properties = new Properties();
            properties.load(stream);
            String name = (String) properties.get("name");
        } catch (MalformedURLException e) {

        } catch (IOException e) {
        }
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        /**
         * 自于servlet规范里的概念，它是servlet用来与容器间进行交互的接口的组合
         * servlet通过这些方法可以很方便地与自己所在的容器进行一些交互，比如通过getMajorVersion与getMinorVersion来获取容器的版本信息等
         * 从它的定义中也可以看出，在一个应用中(一个JVM)只有一个ServletContext, 换句话说，容器中所有的servlet都共享同一个ServletContext
         * ServletContext是容器中所有servlet共享的配置，它在应用中是全局的
         * ServletContext在web应用（服务器）启动时创建
         * ServletContext在web应用（服务器）关闭时释放
         *
         *
         * 添加 事件监听器,获取servlet相关的信息等
         */
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
        String sessionCookieConfigComment = sessionCookieConfig.getComment();
    }
}
