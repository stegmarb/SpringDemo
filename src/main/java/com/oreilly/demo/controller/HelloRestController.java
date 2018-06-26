package com.oreilly.demo.controller;

import com.oreilly.demo.entitites.Greeting;
import com.oreilly.demo.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @Autowired
    private JokeService service;

    @GetMapping("/rest")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        return new Greeting(String.format("Hello, %s!", name));
    }

    @GetMapping("/joke")
    public String getJoke(
        @RequestParam(required = false, defaultValue = "Chuck") String firstName,
        @RequestParam(required = false, defaultValue = "Norris") String lastName) {
        return service.getJoke(firstName, lastName);
    }
}
