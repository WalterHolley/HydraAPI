package com.umsl.hydra.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@RestController
public class HydraController {

    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @RequestMapping(value = "/start", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public String startGame(@RequestParam(required = false, defaultValue = "Sure") String id){
        return String.format("{ \"text\": \"Thanks for playing asshole\"}");
    }
}
