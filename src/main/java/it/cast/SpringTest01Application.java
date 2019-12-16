package it.cast;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@EntityScan()
@MapperScan(value = "it.cast.mapper")
@SpringBootApplication
@EnableCaching                       //开启基于注解的缓存
public class SpringTest01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringTest01Application.class, args);
    }

}
