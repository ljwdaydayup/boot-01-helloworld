package com.liyu.helloworld.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author Levi
 * @date 2019/10/4 11:42
 */
@Data
@Builder
public class PersonPO extends Person{
    private  int  type;
}
