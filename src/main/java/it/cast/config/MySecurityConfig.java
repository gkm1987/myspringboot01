package it.cast.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity //默认带了Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/leave1/**").hasRole("VIP1")
                .antMatchers("/leave2/**").hasRole("VIP2");

//        开启自动配置登录功能
        http.formLogin();
        //1. /login 请求
        //2. /login?error 重定向到登录失败
        //3. 默认
        //4. 默认post 形式的/login 代表登录
        //.loginPage()设置 登录也 更改默认设置
        //..usernameParameter()

//        开启自动配置的注销
        http.logout().logoutSuccessUrl("/");
        //1. 访问 /logout 清空session
        //2 注销成功 返回 /login?login

//        开启记住我
        http.rememberMe();
        //1. 登录成功后有cookie 保存在浏览器中  以后带上这个cookie 只要通过检查就可以等

    }

//    定义认证规则

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2")
                .and()
                .withUser("wangwu").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2");
    }
}
