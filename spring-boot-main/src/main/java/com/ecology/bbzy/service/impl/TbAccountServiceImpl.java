package com.ecology.bbzy.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.ecology.bbzy.entity.TbAccount;
import com.ecology.bbzy.mapper.TbAccountMapper;
import com.ecology.bbzy.service.TbAccountService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bbzyk
 * @since 2023-11-30
 */
@Service
public class TbAccountServiceImpl extends ServiceImpl<TbAccountMapper, TbAccount> implements TbAccountService {

}
