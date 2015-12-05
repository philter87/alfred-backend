package com.alfred.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlfredController {

    @RequestMapping("/abc")
    public String greeting() {
        return "Hello";
    }
}
