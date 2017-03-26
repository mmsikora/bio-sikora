package com.bio.sikora.controller;

import com.bio.sikora.adapter.MessageOfTheDayAdapter;
import com.bio.sikora.entity.MessageOfTheDay;
import com.bio.sikora.repository.MessageOfTheDayRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mmsikora on 3/25/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MessageOfTheDayController.class)
@Import(MessageOfTheDayAdapter.class)
public class MessageOfTheDayControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MessageOfTheDayRepository repository;

    @Test
    public void getMessageOfTheDaySuccess() throws Exception {

        MessageOfTheDay expected = new MessageOfTheDay(Long.valueOf(1), "test");
        List<MessageOfTheDay> expectedList = Arrays.asList(expected);

        Mockito.when(repository.findAll()).thenReturn(expectedList);

        MvcResult result = this.mvc.perform(MockMvcRequestBuilders.get("/api/message-of-the-day"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        MessageOfTheDay actual = objectMapper.readValue(result.getResponse().getContentAsString(), MessageOfTheDay.class);

        System.out.println(result.getResponse().getContentAsString());
        Assert.assertThat(actual.getId(), Is.is(expected.getId()));
        Assert.assertThat(actual.getMessage(), Is.is(expected.getMessage()));
    }

    @Test
    public void getMessageOfTheDayResourceNotFound() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/api/message-of-the-day"))
                .andExpect(MockMvcResultMatchers.status().isConflict());
    }

}
