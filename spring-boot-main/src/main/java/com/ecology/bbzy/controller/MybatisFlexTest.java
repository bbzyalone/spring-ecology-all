package com.ecology.bbzy.controller;


import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static com.ecology.bbzy.entity.table.TbAccountTableDef.TB_ACCOUNT;

@RestController
@RequestMapping("/mpflex")
public class MybatisFlexTest {

    @GetMapping("/test")
    public void test(){
        QueryWrapper queryWrapper = QueryWrapper.create();
        queryWrapper.where(TB_ACCOUNT.ID.ge(100));
        //myTbAccountService.getMapper().deleteByQuery(queryWrapper);
    }



}
