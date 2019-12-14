package it.cast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leave1")
public class Leave1Controller {

    @RequestMapping("/my")
    public String my(){
        return "ZHANGSAN";
    }
}
