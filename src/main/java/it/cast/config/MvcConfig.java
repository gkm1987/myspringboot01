package it.cast.config;

import it.cast.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 这个配置类加了 拦截器
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myInterceptor()).addPathPatterns("/**")
//        .excludePathPatterns("/test/hello")
//
//        ;
    }

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

//    springmvc 路径对应视图设置
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}
