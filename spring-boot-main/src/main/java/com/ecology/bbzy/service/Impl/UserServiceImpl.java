package com.ecology.bbzy.service.Impl;

import com.ecology.bbzy.entity.TbAccount;
import com.ecology.bbzy.mapper.TbAccountMapper;
import com.ecology.bbzy.result.Result;
import com.ecology.bbzy.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TbAccountMapper tbAccountMapper;

    /**
     * 添加一个用户
     *
     * @param tbAccount
     */
    @Override
    public Result addUser(TbAccount tbAccount) {
        tbAccountMapper.insertSelective(tbAccount);
        return Result.success();
    }
}
