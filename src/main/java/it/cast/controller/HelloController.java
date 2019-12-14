package it.cast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {


    @RequestMapping("/hello")
    public String hello(){
//        return "hello";
        return "{h2:1}qq";
    }

    @RequestMapping("/my")
    public String my(){
        return "my";
    }
}
