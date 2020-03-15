package com.pykj.example.one.web;

import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class HelloTest {

    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new IndexController()).build();
    }

   /* @Test
    public void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/index?name=小明").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }*/

}
