package com.liyu.helloworld.common.yml;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Levi
 * @date 2019/10/7 14:13
 */
@Data
@Component
@ConfigurationProperties(prefix = "family")
public class Family {
    //@Value("${family.family-name}")
    private String familyName;
    private Dad dad;
    private Mom mom;
    private Child child;

}

