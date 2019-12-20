package it.cast.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leave1")
public class Leave1Controller {

    @RequestMapping("/my")
    public String my(){
        return getUsername()+ "登录成功";
    }


    //获取单签用户的信息
    private String getUsername(){
        String username = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //获取用户身份
        Object principal = authentication.getPrincipal();
        if(principal == null){
            username = "匿名";
        }

        if (principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        }else{
            username = principal.toString();
        }

        return username;
    }
}
