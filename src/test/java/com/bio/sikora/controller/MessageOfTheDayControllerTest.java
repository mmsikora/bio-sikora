package com.bio.sikora.controller;

import com.bio.sikora.controller.exception.ResourceNotFoundException;
import com.bio.sikora.entity.MessageOfTheDay;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by mmsikora on 3/25/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MessageOfTheDayController.class)
public class MessageOfTheDayControllerTest extends AbstractControllerTest {

    @Test
    public void getMessageOfTheDaySuccess() throws Exception {

        MessageOfTheDay expected = new MessageOfTheDay(1L, "test");

        Mockito.when(messageOfTheDayAdapter.getMessageOfTheDay()).thenReturn(expected);

        MvcResult result = this.mvc.perform(MockMvcRequestBuilders.get("/api/message-of-the-day"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        MessageOfTheDay actual = objectMapper.readValue(result.getResponse().getContentAsString(), MessageOfTheDay.class);

        System.out.println(result.getResponse().getContentAsString());
        Assert.assertThat(actual.getId(), Is.is(expected.getId()));
        Assert.assertThat(actual.getMessage(), Is.is(expected.getMessage()));
    }

    @Test
    public void getMessageOfTheDayResourceNotFound() throws Exception {
        Mockito.when(messageOfTheDayAdapter.getMessageOfTheDay()).thenThrow(ResourceNotFoundException.class);
        this.mvc.perform(MockMvcRequestBuilders.get("/api/message-of-the-day"))
                .andExpect(MockMvcResultMatchers.status().isConflict());
    }

}
