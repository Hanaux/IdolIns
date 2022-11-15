package com.mju.IdolIns.controller;

import com.mju.IdolIns.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/idol", method = {RequestMethod.GET, RequestMethod.POST})
public class MyController {

    @GetMapping("oww")
    public String customerinfo() {

        return "My name is ";
    }
}

