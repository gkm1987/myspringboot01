package it.cast.controller;

import com.alibaba.fastjson.JSONObject;
import it.cast.apodemo.UserLoginToken;
import it.cast.bean.Result;
import it.cast.bean.User;
import it.cast.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    //登录接口 http://ip:端口/user/login
    @RequestMapping(value="/login")
    public Result login(@RequestParam("username") String username
                        ,@RequestParam("password") String password
                        ,HttpSession session){
//        上一次直接放的User user 对象
//        String username = user.getUsername();
//        String password = user.getPassword();
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
            session.setAttribute("loginUser",username);
            return new Result("1", "登录成功1");
        }
        return new Result("0","请核对账密信息！");
    }

    @RequestMapping(value = "/result")
    public Result result(HttpSession httpSession){
        String username = (String) httpSession.getAttribute("loginUser");
        System.out.println(username);
        return new Result("1", "登录成功1"+username);
    }
}

@RestController
@RequestMapping(value = "jwt")
class UserController2 {
    @Autowired
    TokenService tokenService;

    @RequestMapping(value="/ulogin")
    public Object ulogin(User user)
    {
        System.out.println(user);
        JSONObject jsonObject = new JSONObject();

        String token = tokenService.getToken(user);
        jsonObject.put("token",token);
        jsonObject.put("user",user);
        return jsonObject;
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}