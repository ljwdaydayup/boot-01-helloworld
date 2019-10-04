package com.liyu.helloworld.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author Levi
 * @date 2019/10/4 11:30
 */
@Data
public class Person {
    private  String  name;
    private  int aget;
    private  Date birthDate;
}
