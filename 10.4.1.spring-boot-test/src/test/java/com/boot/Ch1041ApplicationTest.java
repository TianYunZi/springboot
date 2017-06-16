package com.boot;

import com.boot.dao.PersonRepository;
import com.boot.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Admin on 2017/6/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Ch1041Application.class)
@WebAppConfiguration
@Transactional
public class Ch1041ApplicationTest {

    @Autowired
    private PersonRepository personRepository;

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private String expectJson;

    @Before
    public void setUp() throws JsonProcessingException {
        Person person1 = new Person("wyf");
        Person person2 = new Person("wisely");
        personRepository.save(person1);
        personRepository.save(person2);

        expectJson = Obj2Json(personRepository.findAll());
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    private String Obj2Json(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    @Test
    public void testPersonController() throws Exception {
        String uri = "/person";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("错误，正确的返回值是200", 200, status);
        Assert.assertEquals("错误，返回值和预期返回值不一致", expectJson, content);
    }
}
