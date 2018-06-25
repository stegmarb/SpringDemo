package com.oreilly.demo.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

public class HelloControllerUnitTests {
    @Test
    public void testSayHello() throws Exception {
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = controller.sayHello("World", model);
        assertEquals("World", model.asMap().get("user"));
        assertEquals("hello", result);
    }
}