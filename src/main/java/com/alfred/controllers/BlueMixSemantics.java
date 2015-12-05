package com.alfred.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlueMixSemantics {
    @RequestMapping("/semantics-analysis")
    public String getKeyWord(@RequestParam String sentence){
        return "";
    }
}
