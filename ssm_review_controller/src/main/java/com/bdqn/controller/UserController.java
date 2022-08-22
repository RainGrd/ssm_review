package com.bdqn.controller;

import com.bdqn.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/8/22 20:39
 * FileName: UserController
 * Description: 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 用户查询
     */
    @RequestMapping("/getUserAll")
    @ResponseBody
    public String getUserAll() throws JsonProcessingException {
        System.out.println(userService.getUserAll());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userService.getUserAll());
    }
}
