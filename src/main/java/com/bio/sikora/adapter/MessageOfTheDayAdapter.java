package com.bio.sikora.adapter;

import com.bio.sikora.controller.exception.ResourceNotFoundException;
import com.bio.sikora.entity.MessageOfTheDay;
import com.bio.sikora.repository.MessageOfTheDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by mmsikora on 3/25/17.
 */
@Component
public class MessageOfTheDayAdapter {

    @Autowired
    private MessageOfTheDayRepository repository;

    public MessageOfTheDay getMessageOfTheDay() {
        List<MessageOfTheDay> messages = (List<MessageOfTheDay>) repository.findAll();
        if (messages == null || messages.size() > 0) {
            throw new ResourceNotFoundException("No messages of the day found, sad.");
        }
        return messages.get(0);
    }
}
