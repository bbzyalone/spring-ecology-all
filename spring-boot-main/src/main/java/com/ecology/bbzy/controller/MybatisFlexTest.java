package com.ecology.bbzy.controller;


import com.ecology.bbzy.result.Result;
import com.ecology.bbzy.service.UserService;
import com.ecology.bbzy.entity.TbAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mpflex")
public class MybatisFlexTest {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public Result test() {
        TbAccount tbAccount = new TbAccount();
        tbAccount.setUserName("我就想不通了");
        return userService.addUser(tbAccount);
    }


}
