package com.ecology.bbzy.controller;


import com.ecology.bbzy.model.User;
import com.ecology.bbzy.result.Result;
import com.ecology.bbzy.result.ResultCode;
import com.ecology.bbzy.redisson.RedisUtil;
import com.ecology.bbzy.socket.EchoChannel;
import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private EchoChannel echoChannel;


    @GetMapping("/get")
    public Result<User> getTest() {
        boolean lock = redisUtil.lock("mylock", 3);
        if (lock) {
            return Result.success();
        } else {
            return Result.failed(ResultCode.FLOW_LIMITING);
        }
    }

    @GetMapping("/get1")
    public Result gettest1() {


        return Result.success();
    }

    @GetMapping("/puSocket")
    public void puSocket(@RequestParam("token") String token, @RequestParam("message") String message) {
        echoChannel.sendMessage(token, message);
    }
}
