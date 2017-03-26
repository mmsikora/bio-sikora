package com.bio.sikora;

import com.bio.sikora.adapter.MessageOfTheDayAdapter;
import com.bio.sikora.controller.MessageOfTheDayController;
import com.bio.sikora.entity.MessageOfTheDay;
import com.bio.sikora.loader.MessageOfTheDayLoader;
import com.bio.sikora.repository.MessageOfTheDayRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by mmsikora on 3/25/17.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MessageOfTheDayLoader setupLoader() {
        return new MessageOfTheDayLoader();
    }
}
