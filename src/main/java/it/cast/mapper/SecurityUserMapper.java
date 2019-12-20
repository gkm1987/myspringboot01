package it.cast.mapper;

import it.cast.bean.PermissionDto;
import it.cast.bean.UserDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SecurityUserMapper {

    @Select("select * from t_user where username=#{username}")
    public UserDto getUserByUsername(String username);

    public List<PermissionDto> findPermissionsByUserId(Integer userId);
}
