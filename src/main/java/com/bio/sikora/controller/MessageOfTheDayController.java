package com.bio.sikora.controller;

import com.bio.sikora.adapter.MessageOfTheDayAdapter;
import com.bio.sikora.entity.MessageOfTheDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mmsikora on 3/25/17.
 */
@RestController
public class MessageOfTheDayController {

    @Autowired
    private MessageOfTheDayAdapter messageOfTheDayAdapter;

    @GetMapping(path = "/api/message-of-the-day")
    public ResponseEntity<MessageOfTheDay> getMessageOfTheDay() {
        return new ResponseEntity<MessageOfTheDay>(messageOfTheDayAdapter.getMessageOfTheDay(), HttpStatus.OK);

    }
}
