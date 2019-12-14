package it.cast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leave2")
public class Leave2Controller {

    @RequestMapping("/my")
    public String my(){
        return "LISI";
    }
}
