package com.bio.sikora.loader;

import com.bio.sikora.entity.MessageOfTheDay;
import com.bio.sikora.repository.MessageOfTheDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * Created by mmsikora on 3/25/17.
 */
public class MessageOfTheDayLoader implements CommandLineRunner {

    @Autowired
    private MessageOfTheDayRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new MessageOfTheDay("Hello All!"));
    }

}
