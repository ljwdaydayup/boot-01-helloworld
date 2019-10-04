package com.liyu.helloworld.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Levi
 * @date 2019/9/18 9:31
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Animal {
        private  String name;
        private  Integer type;
        private  String num;
        private  Long id;
        private Date birthDate;
        List<Animal> animalList;
        private Animal animal2;
}
