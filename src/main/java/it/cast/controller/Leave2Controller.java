package it.cast.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leave2")
public class Leave2Controller {
    @PreAuthorize("hasAnyAuthority('VIP2')")
    @RequestMapping("/my")
    public String my(){
        return "LISI";
    }
}
