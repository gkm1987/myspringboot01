package it.cast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginResult {
    @RequestMapping("/login-success")
    public String my(){
        return "登录成功";
    }
}
