package com.bio.sikora.repository;

import com.bio.sikora.entity.MessageOfTheDay;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mmsikora on 3/25/17.
 */
public interface MessageOfTheDayRepository extends CrudRepository<MessageOfTheDay, Long> {
}
