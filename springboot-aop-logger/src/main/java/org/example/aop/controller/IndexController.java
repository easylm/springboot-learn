package org.example.aop.controller;

import org.example.aop.annotation.CustomLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/test")
    @CustomLog("基础web")
    public String test(){
        return "hello 使用 springboot-learning";
    }

}
