package it.cast.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //默认带了Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    //安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        定制请求的授权规则
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login*").permitAll()
//                .antMatchers("/leave1/**").hasAnyAuthority("VIP1")
//                .antMatchers("/leave2/**").hasAnyAuthority("VIP2")
                .and()
                .formLogin()
//                .successForwardUrl("/login-success")
//                .loginPage() //登录的界面地址
//                .loginProcessingUrl()//登录的请求路径
//                .permitAll()
//                .and()


        ;

//        开启自动配置登录功能
//        http.formLogin();
        //1. /login 请求
        //2. /login?error 重定向到登录失败
        //3. 默认
        //4. 默认post 形式的/login 代表登录
        //.loginPage()设置 登录也 更改默认设置
        //..usernameParameter()

//        开启自动配置的注销
//        http.logout().logoutSuccessUrl("/");
        //1. 访问 /logout 清空session
        //2 注销成功 返回 /login?login

//        开启记住我
//        http.rememberMe();
        //1. 登录成功后有cookie 保存在浏览器中  以后带上这个cookie 只要通过检查就可以等

    }

//    内存定义用户

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1")
//                .and()
//                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2")
//                .and()
//                .withUser("wangwu").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2");

    }


    // 密码编码器 (密码比对)
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    定义用户信息服务(查询用户信息) 这个定义内容的方式上面的成功这里不成功 重写成功 角色和权限没有分清
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("zl").password("123456").authorities("VIP1").build());
//        return manager;
//    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
