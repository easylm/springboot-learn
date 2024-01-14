package org.example.secuuity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "请求成功";
    }

    @GetMapping("/get")
    public String get() {
        return "神秘代码9527";
    }
}
