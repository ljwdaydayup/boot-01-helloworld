package com.liyu.helloworld.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
@JsonPropertyOrder(value={"id","type"})//更换变量显示顺序
public class Animal {
        @JsonIgnore      //不支持序列化，不能传参
        private  String name;
        @JsonProperty("type1")
        private  Integer type;
        //空值不返回
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private  String num;
        private  Long id;
        private Date birthDate;
        List<Animal> animalList;
        private Animal animal2;
}
