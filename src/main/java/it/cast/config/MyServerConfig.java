package it.cast.config;

import it.cast.filter.MyFilter;
import it.cast.interceptor.MyInterceptor;
import it.cast.listener.MyListener;
import it.cast.servlet.MyServlet;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.Filter;
import java.util.Arrays;

/**
 * 服务器相关配置
 */
@Configuration
public class MyServerConfig {

    //注册三大组件
//  注册监听器
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean registrationBean;
        registrationBean = new ServletListenerRegistrationBean (new MyListener());
        return registrationBean;
    }

//  注册过滤器
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));

        return filterRegistrationBean;
    }

//    注册servlet
    @Bean
    public ServletRegistrationBean<MyServlet> myServlet(){
        return new ServletRegistrationBean<>(new MyServlet(),"/myServlet");
    }

    //配置嵌入式的servlet容器
    @Bean
    public TomcatServletWebServerFactory servletWebServerFactory(){
        //这里的测试生效 印在配置文件中配了 8080
        return new TomcatServletWebServerFactory(8081);
    }
}
