package com.paloit.card.server.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping(path = "/")
    public String root() {
        return "Card Service";
    }
}
