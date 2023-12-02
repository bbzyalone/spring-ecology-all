package com.spreco.bbzy;

import com.spreco.bbzy.optional.User;
import com.spreco.bbzy.optional.UserInfo;
import junit.framework.TestCase;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest extends TestCase {

    public void test() {
        User user = new User();
        user.setId(123456L);
        user.setName("bbzy");


        //创建  使用 of 方法创建一个包含非空值的 Optional 对象。
        Optional<User> user1 = Optional.of(user);

        //使用 ofNullable 方法创建一个包含可空值的 Optional 对象。
        Optional<UserInfo> user2 = Optional.ofNullable(user.getUserInfo());

        //使用 isPresent 方法判断值是否存在。
        if (user1.isPresent()) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }

        if (user2.isPresent()) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");
        }

        var userInfo = new UserInfo();
        //使用 ifPresent 方法，在值存在时执行某个操作。
        Optional.ofNullable(userInfo).ifPresent(u -> {
            System.out.println("存在 userInfo");
        });
        userInfo.setInfo("hahahaha");

        Optional.ofNullable(userInfo.getInfo()).ifPresent(System.out::println);

        //使用 orElse 方法，如果值存在则返回值，否则返回默认值。
        var userInfo1 = Optional.ofNullable(userInfo).orElse(new UserInfo());

        //如果值不存在则提供一个函数生成的默认值：
        //使用 orElseGet 方法，接受一个 Supplier 函数，用于生成默认值。
        Optional.ofNullable(null).orElseGet(UserInfo::new);

        //如果不存在则抛出异常
        //Optional.ofNullable(userInfo.getId()).orElseThrow(() -> new NoSuchElementException("未找到用户id"));  //自定义异常说明
        //Optional.ofNullable(userInfo.getId()).orElseThrow(NoSuchElementException::new);


    }
}
