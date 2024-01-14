package org.example.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.swagger.entity.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fausto
 */
@RestController
@Api(tags = "UserController:用户信息管理接口")
public class UserController {

    @GetMapping("/get")
    @ApiOperation("获取数据")
    public User get() {
        return new User().setUserId(1L).setSex("man").setUsername("王小五");
    }

    @PostMapping("/add")
    @ApiOperation("添加数据")
    public String add(User user) {
        return "添加数据成功";
    }
    @DeleteMapping("/del")
    @ApiOperation("删除数据")
    public String del() {
        return "删除数据成功";
    }


    @PostMapping("/upd")
    @ApiOperation("删除数据")
    public String upd() {
        return "更新数据成功";
    }
}
