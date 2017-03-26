package com.bio.sikora.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mmsikora on 3/25/17.
 */
@Entity
public class MessageOfTheDay {

    @Id
    @GeneratedValue
    private Long id;
    private String message;

    public MessageOfTheDay() {
    }

    public MessageOfTheDay(String message) {
        this.message = message;
    }

    public MessageOfTheDay(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageOfTheDay{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
