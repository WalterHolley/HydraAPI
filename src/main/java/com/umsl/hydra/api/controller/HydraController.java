package com.umsl.hydra.api.controller;

import com.umsl.hydra.api.model.GameResponse;
import com.umsl.hydra.api.model.StartGameRequest;
import com.umsl.hydra.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;



@RestController
public class HydraController {

    @Autowired
    private GameService gameService;

    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PostMapping(value = "/start", produces = MediaType.APPLICATION_JSON_VALUE)
    public GameResponse startGame(HttpSession  session, @RequestBody StartGameRequest request){

        return gameService.startGameSession(session, request);
    }

    @PostMapping(value = "/play", produces = MediaType.APPLICATION_JSON_VALUE)
    public GameResponse playRound(HttpSession session, @RequestBody String body){
        return gameService.updateGameSession(session, gameService.getGameSession(session));
    }
}
