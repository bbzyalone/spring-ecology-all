package com.ecology.bbzy.service;

import com.ecology.bbzy.result.Result;
import com.ecology.bbzy.entity.TbAccount;

public interface UserService {

    /**
     * 添加一个用户
     */
    Result addUser(TbAccount tbAccount);
}
