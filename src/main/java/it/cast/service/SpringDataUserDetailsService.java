package it.cast.service;

import it.cast.bean.PermissionDto;
import it.cast.bean.UserDto;
import it.cast.mapper.SecurityUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 继承 UserDetailsService 成功返回userDetails 说明认证成功
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    SecurityUserMapper securityUserMapper;

    //根据账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //链接数据根据账号查询用户信息
        UserDto userDto = securityUserMapper.getUserByUsername(username);
        if(userDto == null){
            //如果用户查不到 返回为null 由provider来跑出异常
            return null;
        }else{
            List<PermissionDto> permissionDtos = securityUserMapper.findPermissionsByUserId(userDto.getId());
            List<String> permissions = new ArrayList<>();
            //把code 权限表示符
            permissionDtos.forEach(c->permissions.add(c.getCode()));

            String[]  permissionArray = new String[permissions.size()];
            permissions.toArray(permissionArray);

            UserDetails userDetails = User.withUsername(userDto.getUsername())
                    .password(userDto.getPassword())
                    .authorities(permissionArray)
                    .build();
            return userDetails;
        }

        //登录账号
//        System.out.println("username="+username);

        //暂时采用模拟方式 123
//        UserDetails userDetails = User.withUsername("zhangsana")
//                .password("$2a$10$JH.KYUl.lh34pmUIDs3yZOr8Q9fFrqHqW4zE6v.GTnTDQcv7JHxpG")
//                .authorities("VIP1")
//                .build();
//        return userDetails;
    }
}
