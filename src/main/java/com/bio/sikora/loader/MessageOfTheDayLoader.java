package com.bio.sikora.loader;

import com.bio.sikora.adapter.MessageOfTheDayAdapter;
import com.bio.sikora.entity.MessageOfTheDay;
import com.bio.sikora.repository.MessageOfTheDayRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import javax.transaction.Transactional;

/**
 * Created by mmsikora on 3/25/17.
 */
public class MessageOfTheDayLoader implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(MessageOfTheDayAdapter.class);

    @Autowired
    private MessageOfTheDayRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Start saving seed data");
        seedData();
        logger.info("Complete seed data");
    }

    @Transactional
    private void seedData() {
        this.repository.save(new MessageOfTheDay("Hello All!"));
    }

}
