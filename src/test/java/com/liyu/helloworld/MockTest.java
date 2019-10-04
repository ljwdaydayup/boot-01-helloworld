package com.liyu.helloworld;

import com.liyu.helloworld.controller.AnimalController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author Levi
 * @date 2019/10/4 21:09
 */
//@Transactional
/**
 * @author Levi
 * @date 2019/10/4 21:09
 */
//@Transactional
@Slf4j
@SpringBootTest
public class MockTest {

    private MockMvc mockMvc;

    //它是不在spring容器中的，需要手动引入
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AnimalController()).build();
    }

    @Test
    public void saveArticle() throws Exception {
        //直接将前面请求的例子粘贴过来会自动分行
        String animal = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"pig\",\n" +
                "    \"type1\": \"\",\n" +
                "    \"birthDate\":\"2019-10-04T05:10:10\",\n" +
                "    \"animalList\":[{\"name\":\"dog\",\"type\":5},{\"name\":\"dog\",\"type\":10}]\n" +
                "}";
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
