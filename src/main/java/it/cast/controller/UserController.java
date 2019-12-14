package it.cast.controller;

import it.cast.bean.Result;
import it.cast.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    //登录接口 http://ip:端口/user/login
    @RequestMapping(value="/login")
    public Result login(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        //1.用户名为空提示"用户名不能为空"
        if(username==null || username.trim().length()==0) {
            return new Result("0","用户名不能为空 sdzzzzz");
        }
        //2.密码为空,提示"密码不能为空"
        if(password==null || password.trim().length()==0) {
            return new Result("0","密码不能为空");
        }
        //3.用户名密码不为空的情况下jdbc完成数据库查询验证
        if(username != null && password!=null) {
//            int num = SQLUtil.findSQL(user);
//            System.out.println("-------------------------"+num+"--------------------------------");
//            if(num>0) {
//                return new Result("1", "登录成功");
//            }

            return new Result("1", "登录成功1");
        }
        return new Result("0","请核对账密信息！");
    }
}
