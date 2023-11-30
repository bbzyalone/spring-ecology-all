package com.ecology.bbzy.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.ecology.bbzy.entity.TbInfo;
import com.ecology.bbzy.mapper.TbInfoMapper;
import com.ecology.bbzy.service.TbInfoService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author bbzyk
 * @since 2023-11-30
 */
@Service
public class TbInfoServiceImpl extends ServiceImpl<TbInfoMapper, TbInfo> implements TbInfoService {

}
