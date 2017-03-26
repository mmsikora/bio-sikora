package com.bio.sikora.controller;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by mmsikora on 3/25/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHelloTest() throws Exception {
        MvcResult result = this.mvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String actual = result.getResponse().getContentAsString();

        Assert.assertThat(actual, Is.is("Hello"));
    }
}
