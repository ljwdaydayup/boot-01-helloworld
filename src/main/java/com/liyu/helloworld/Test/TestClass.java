package com.liyu.helloworld.Test;

import com.liyu.helloworld.domain.Person;
import com.liyu.helloworld.domain.PersonPO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Levi
 * @date 2019/10/4 11:31
 */
@Slf4j
public class TestClass {
    public static void main(String[] args){
        Person p = new Person();
        p.setName("levi");
        log.error(p.getName());

        PersonPO personPO = PersonPO.builder().type(1).build();
        personPO.setName("no2");

    }
}
