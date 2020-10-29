package com.cloud.dandan.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class UserController {

    @RequestMapping("getUser")
    public String getUser(){
        return "眈眈||虎视眈眈-IDEA-2";
    }
}
