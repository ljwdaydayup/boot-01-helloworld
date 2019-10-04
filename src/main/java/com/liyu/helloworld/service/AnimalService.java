package com.liyu.helloworld.service;

import com.liyu.helloworld.domain.Animal;
import org.springframework.stereotype.Service;

/**
 * @author Levi
 * @date 2019/10/4 22:10
 */
@Service
public class AnimalService {

    public String saveAnimal(Animal animal){
        return "测试animal";
    }

}
