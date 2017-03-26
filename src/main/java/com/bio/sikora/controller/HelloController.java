package com.bio.sikora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mmsikora on 3/25/17.
 */
@RestController
public class HelloController {

    @GetMapping(path="/hello")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }
}
