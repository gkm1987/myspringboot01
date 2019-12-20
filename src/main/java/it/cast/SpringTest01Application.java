package it.cast;

import it.cast.interceptor.MyInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EntityScan()
@MapperScan(value = "it.cast.mapper")
@SpringBootApplication
@EnableCaching                       //开启基于注解的缓存
public class SpringTest01Application  {

    public static void main(String[] args) {
        SpringApplication.run(SpringTest01Application.class, args);
    }

}
