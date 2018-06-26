package com.oreilly.demo.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JokeServiceTest {
    @Autowired
    private JokeService service;

    @Test
    public void getJoke() throws Exception {
        String joke = service.getJoke("Craig", "Walls");
        assertTrue(joke.contains("Craig") ||
            joke.contains("Walls"));
    }

}