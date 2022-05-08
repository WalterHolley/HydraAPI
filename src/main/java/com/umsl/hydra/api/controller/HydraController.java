package com.umsl.hydra.api.controller;

import com.umsl.hydra.api.model.GameRequest;
import com.umsl.hydra.api.model.GameResponse;
import com.umsl.hydra.api.model.StartGameRequest;
import com.umsl.hydra.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
public class HydraController {

    @Autowired
    private GameService gameService;

    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PostMapping("/start")
    @ResponseBody
    public GameResponse startGame(Model model, HttpSession session, @RequestBody StartGameRequest request){

        return gameService.startGameSession(session, request);
    }

    @PostMapping("/play")
    @ResponseBody
    public GameResponse playGame(HttpSession session, @RequestBody  GameRequest request){

        return gameService.updateGameSession(session, request);
    }
}
