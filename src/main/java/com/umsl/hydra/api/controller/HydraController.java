package com.umsl.hydra.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HydraController {

    @GetMapping("/start")
    public String startGame(){
        return String.format("Thanks for playing asshole");
    }
}
