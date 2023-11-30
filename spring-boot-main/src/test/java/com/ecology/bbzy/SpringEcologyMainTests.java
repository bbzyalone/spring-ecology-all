package com.ecology.bbzy;

import com.ecology.bbzy.entity.TbAccount;
import com.ecology.bbzy.mapper.TbAccountMapper;
import com.ecology.bbzy.service.TbAccountService;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.ecology.bbzy.entity.table.TbAccountTableDef.TB_ACCOUNT;

@SpringBootTest
class SpringEcologyMainTests {

    @Autowired
    private TbAccountService TbAccountService;
    @Autowired
    private TbAccountMapper tbAccountMapper;
    /**
     * 单个插入
     */
    @Test
    void contextLoads() {

        TbAccount tbAccount = new TbAccount();
        tbAccount.setUserName(null);
        tbAccount.setAge(50);
        tbAccount.setBirthday(LocalDateTime.now());
        tbAccountMapper.insert(tbAccount);
        TbAccount tbAccount2 = new TbAccount();
        tbAccount2.setUserName(null);
        tbAccount2.setAge(50);
        tbAccount2.setBirthday(LocalDateTime.now());
        tbAccountMapper.insertSelective(tbAccount2);//忽略 null 的数据



    }

    /**
     * 批量插入
     */
    @Test
    void test1() {
        List<TbAccount> tbAccountList = new ArrayList<>();
        //批量插入
        for (int i = 0; i < 50; i++) {
            TbAccount tbAccount = new TbAccount();
            tbAccount.setAge(50);
            tbAccount.setBirthday(LocalDateTime.now());
            tbAccountList.add(tbAccount);
        }
        TbAccountService.getMapper().insertBatch(tbAccountList);
        TbAccountService.getMapper().insertBatch(tbAccountList, 20);//批量插入实体类数据，按 size 切分
    }

    /**
     * 插入或者更新
     */
    @Test
    void test2() {
        List<TbAccount> tbAccountList = new ArrayList<>();

        TbAccount tbAccount = new TbAccount();
        tbAccount.setId(1);
        tbAccount.setUserName("老王");
        tbAccount.setAge(50);
        tbAccount.setBirthday(LocalDateTime.now());
        tbAccountList.add(tbAccount);
        TbAccountService.getMapper().insertOrUpdateSelective(tbAccount);//忽略 null 若主键有值，则更新，若没有主键值，则插入

    }

    /**
     * 插入 使用数据库函数或方法
     */
    @Test
    void test3() {
        TbAccount tbAccount = new TbAccount();
        tbAccount.setAge(50);

        TbAccount newAccount = UpdateWrapper.of(tbAccount)
                .setRaw(TbAccount::getUserName, "(SELECT appkey FROM `tb_info` where id = 1)") //不能使用当前要插入的表
                .setRaw(TbAccount::getBirthday, "now()")
                .toEntity();
        TbAccountService.getMapper().insert(newAccount);
    }

    /**
     * 删除数据
     * delete(entity) 便于对复合主键实体类的删除
     */
    @Test
    void test4() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        TbAccountService.getMapper().deleteBatchByIds(integerList);

    }

    /**
     * 根据条件删除
     */
    @Test
    void test5() {
        QueryWrapper queryWrapper = QueryWrapper.create();
        queryWrapper.where(TB_ACCOUNT.ID.ge(90));
        TbAccountService.getMapper().deleteByQuery(queryWrapper);
    }

    /**
     * 根据条件删除
     * */
    @Test
    void test6(){
        //myTbAccountService.getMapper().deleteByCondition();
       // MyBatis-Flex 使用了 APT 技术，这个 ACCOUNT 是自动生成的
    }

}
