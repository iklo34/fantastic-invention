package com.example.Del.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelController {
    @GetMapping("/")
    public String index() {
    return "MY little Hello World";
    }
}
