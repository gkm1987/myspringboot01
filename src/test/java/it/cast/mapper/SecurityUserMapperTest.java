package it.cast.mapper;

import it.cast.bean.PermissionDto;
import it.cast.bean.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityUserMapperTest {

    @Autowired
    SecurityUserMapper securityUserMapper;

    @Test
    public void getUserByUsername() {
        UserDto zhangsan = securityUserMapper.getUserByUsername("zhangsan");


        if(zhangsan !=null){
            System.out.println(zhangsan.getId());
            System.out.println(zhangsan);
        }else{
            System.out.println("没查询到");
        }

    }

    @Test
    public void findPermissionsByUserId(){
        List<PermissionDto> permissionDtos = securityUserMapper.findPermissionsByUserId(1);
        List<String> permissions = new ArrayList<>();
        //把code 权限表示符
        permissionDtos.forEach(c->permissions.add(c.getCode()));
        System.out.println(permissions);
    }
}