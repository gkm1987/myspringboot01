package it.cast.security.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 *
 */
@Configuration
public class TokenConfig {
    private String SIGNING_KEY = "uaa123";



    @Bean
    public TokenStore tokenStore(){
        //jwt令牌的bean 存储
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY); //对称秘钥资源服务器使用该秘钥来验证
        return converter;
    }
//    @Bean
//    public TokenStore tokenStore(){
//        //内存方式 生成普通令牌 令牌存储的策略
//        return new InMemoryTokenStore();
//    }

}
