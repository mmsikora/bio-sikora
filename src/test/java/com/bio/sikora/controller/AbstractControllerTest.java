package com.bio.sikora.controller;

import com.bio.sikora.adapter.MessageOfTheDayAdapter;
import com.bio.sikora.repository.MessageOfTheDayRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by mmsikora on 3/27/17.
 */
public abstract class AbstractControllerTest {

    @Autowired
    protected MockMvc mvc;
    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    protected MessageOfTheDayRepository repository;
    @MockBean
    protected MessageOfTheDayAdapter messageOfTheDayAdapter;
}
