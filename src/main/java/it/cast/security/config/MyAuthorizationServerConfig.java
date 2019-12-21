package it.cast.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfig implements AuthorizationServerConfigurer {
    @Autowired
    private TokenStore tokenStore;

    //    令牌的端点注入
    @Autowired
    private AuthorizationCodeServices authorizationCodeServices; //授权码模式
    @Autowired
    private AuthenticationManager authenticationManager; //密码模式

    //      令牌服务注入
    @Autowired
    private ClientDetailsService clientDetailsService;

    //    配置令牌端点的安全策略(安全约束)
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")          //oauth/token_key是公开的jwt 公有秘钥的端点
                .checkTokenAccess("permitAll()")        //oauth/check_token公开
                .allowFormAuthenticationForClients()    //允许表单认证
                ;
    }

//    用来配置客户端详情服务
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //暂时使用内存方式
        clients.inMemory()
                //客户端id
                .withClient("c1")
                //客户端秘钥
                .secret(new BCryptPasswordEncoder().encode("secret"))
                //访问资源列表
                .resourceIds("res1")
                //方式
                .authorizedGrantTypes("authorization_code","password","client_credentials","implicit","refresh_token")
                //允许授权范围 哪些service
                .scopes("all")
                //false 跳转到授权的页面 true 不用跳转直接发令牌
                .autoApprove(false)
                //验证回调地址
                .redirectUris("http://www.baidu.com");

    }

//    配置令牌访问端点---------和令牌服务 申请令牌的url
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)       //密码模式
                .authorizationCodeServices(authorizationCodeServices)//授权模式
                .tokenServices(tokenServices())             //令牌管理的服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);   //post提交
    }

//    令牌服务配置

    @Bean
    public AuthorizationServerTokenServices tokenServices(){
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService); //客户端信息服务
        services.setSupportRefreshToken(true);         //是否产生刷新令牌
        services.setTokenStore(tokenStore);             //令牌的存储策略
        services.setAccessTokenValiditySeconds(7200);//令牌有效期
        services.setRefreshTokenValiditySeconds(259200);//刷新令牌默认有效期三天
        return services;
    }

    //设置授权码模式如何存取 暂时采用内存方式
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){

        return new InMemoryAuthorizationCodeServices();
    }

}
