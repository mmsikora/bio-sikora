package com.bio.sikora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mmsikora on 3/27/17.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }

}
