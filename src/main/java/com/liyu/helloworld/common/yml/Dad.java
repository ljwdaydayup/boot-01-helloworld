package com.liyu.helloworld.common.yml;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author Levi
 * @date 2019/10/7 14:09
 */
@Data
public class Dad {
    private String name;
    //@Min(50)
    private  int age;

}
