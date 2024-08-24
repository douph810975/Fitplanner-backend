package com.example.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @RequestMapping("/test")
    public Map<String, String> hello() {
        Map<String, String> map = new HashMap<>();
        map.put("status", "Ok");
        map.put("msg","hello,world");
        return map;
    }
}
