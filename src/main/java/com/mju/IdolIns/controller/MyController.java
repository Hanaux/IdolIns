package com.mju.IdolIns.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyController {

    @GetMapping("healthCheck")
    public String healthCheck(){
        return "Is Alive";
    }
}
