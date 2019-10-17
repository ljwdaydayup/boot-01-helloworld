package com.liyu.helloworld.common.yml;

import lombok.Data;

import java.util.List;

/**
 * @author Levi
 * @date 2019/10/7 14:12
 */
@Data
public class Child {

    private  int age;

    private List<Friend> friends;

}
