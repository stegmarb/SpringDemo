package com.oreilly.demo.service;

import com.oreilly.demo.json.JokeResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class JokeService {

    private RestTemplate template;
    private Logger logger = LoggerFactory.getLogger(JokeService.class);
    private static final String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

    public JokeService(RestTemplateBuilder builder) {
        this.template = builder.build();
    }

    public String getJoke(String first, String last) {
        String url = String.format("%s&firstName=%s&lastName=%s", BASE, first, last);
        JokeResponse jokeResponse = template.getForObject(url, JokeResponse.class);
        logger.info(jokeResponse.getValue().getJoke());
        return jokeResponse.getValue().getJoke();
    }
}
