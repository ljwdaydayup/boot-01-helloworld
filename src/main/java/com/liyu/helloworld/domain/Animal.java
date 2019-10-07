package com.liyu.helloworld.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
