package com.liyu.helloworld;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liyu.helloworld.controller.AnimalController;
import com.liyu.helloworld.domain.Animal;
import com.liyu.helloworld.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * 在轻量级容器中的测试
 * @author Levi
 * @date 2019/10/4 21:09
 */
//@Transactional
@Slf4j
//@SpringBootTest
@WebMvcTest      //注入所有controller  甚至可以注入指定controller @WebMvcTest(AnimalController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MockTestSimple {


    @Resource
    private MockMvc mockMvc;
    @MockBean
    private AnimalService animalService;
    @Test
    public void saveArticle() throws Exception {
        String animal = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"pig\",\n" +
                "    \"type\": \"\",\n" +
                "    \"birthDate\":\"2019-10-04T05:10:10\",\n" +
                "    \"animalList\":[{\"name\":\"dog\",\"type\":5},{\"name\":\"dog\",\"type\":10}]\n" +
                "}";

        log.error("animal"+animalService.saveAnimal(null));
        ObjectMapper objectMapper = new ObjectMapper();
        Animal animalObj = objectMapper.readValue(animal,Animal.class);

        //打桩--当controller调用改service时，模拟返回一个ok
        when(animalService.saveAnimal(animalObj)).thenReturn("ok");

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/animals")
                        .contentType("application/json").content(animal))
                .andExpect(MockMvcResultMatchers.status().isOk())//返回状态200为成功
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("pig"))//返回属性name为pig
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.animalList[0].type").value(5))//返回属性type需要为5
                .andDo(print())
                .andReturn();

        log.info(result.getResponse().getContentAsString());
    }
}
