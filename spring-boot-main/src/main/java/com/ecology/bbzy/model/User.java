package com.ecology.bbzy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //数据对象为空时去掉接口返回
public class User {

    private String name;
    private int age;
    private String info;
    private String userInfo;
}
