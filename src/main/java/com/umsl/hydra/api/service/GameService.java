package com.umsl.hydra.api.service;
/*
AI Utility
This is where the base functions for the game's decision making will be processed.
 */

import com.umsl.hydra.api.model.*;
import com.umsl.hydra.api.utility.AIUtility;
import com.umsl.hydra.api.utility.GameUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class GameService {

    @Autowired
    private GameUtility gameUtility;

    @Autowired
    private AIUtility aiUtility;

    /**
     * Begins a game session
     * @param session Http session of client
     * @param request game start request(requested game difficulty setting)
     * @return GameResponse object for the new game
     */
    public GameResponse startGameSession(HttpSession session, StartGameRequest request){
        GameResponse response;

        //init game
        response  = initGame();
        //init session attributes
        initGameSession(session, response, request);

        return response;

    }

    public GameResponse updateGameSession(HttpSession session, GameRequest request){
        DifficultyEnum difficultyEnum;
        //get game difficulty
        difficultyEnum = gameUtility.getDifficultyByCode((int)session.getAttribute(GameConstants.SESSION_GAMEDIFFICULTY_KEY));

        //get current game session stats
        GameResponse response = getGameSession(session);

        //get win decision from AI
        if(aiUtility.wonRound(difficultyEnum, request.getDirectionSequence())){
            //handle player win

            if(request.getAction() == 1){
                response.setEnemyHp(response.getEnemyHp() - GameConstants.BASE_PLAYER_ATK);
            }
            else{
                response.setPlayerHp(response.getPlayerHp() + GameConstants.BASE_PLAYER_HEAL);
            }

        }
        else{
            //handle enemy win
            response.setPlayerHp(response.getPlayerHp() - GameConstants.BASE_ENEMY_ATK);

        }

        if(response.getEnemyHp() <= 0 || response.getPlayerHp() <= 0){

            response.setIsGameOver(true);

            if( response.getEnemyHp() <= 0){
                //TODO: Check for high score candidate
                response.setPlayerWon(true);
            }
            else
                response.setPlayerWon(false);
            //end game session
            session.invalidate();

            //check for high score
        }
        else{
            response.setGameRound(response.getGameRound() + 1);
            session.setAttribute(GameConstants.SESSION_GAMEROUNDS_KEY, response.getGameRound());
            session.setAttribute(GameConstants.SESSION_PLAYERHP_KEY,response.getPlayerHp());
            session.setAttribute(GameConstants.SESSION_ENEMYHP_KEY, response.getEnemyHp());
            session.setAttribute(GameConstants.SESSION_PLAYERWON_KEY, response.getPlayerWon());
        }
        return response;
    }

    /**
     * Retrieves game response representation of game session object
     * @param session
     * @return
     */
    public GameResponse getGameSession(HttpSession session){
        GameResponse response = new GameResponse();


        response.setGameRound((int)session.getAttribute(GameConstants.SESSION_GAMEROUNDS_KEY));
        response.setGameDifficulty(gameUtility.getDifficultyByCode((int)session.getAttribute(GameConstants.SESSION_GAMEDIFFICULTY_KEY)));
        response.setPlayerWon((boolean)session.getAttribute(GameConstants.SESSION_PLAYERWON_KEY));
        response.setPlayerHp((int) session.getAttribute(GameConstants.SESSION_PLAYERHP_KEY));
        response.setEnemyHp((int) session.getAttribute(GameConstants.SESSION_ENEMYHP_KEY));

        return response;
    }

    private GameResponse initGame(){
        GameResponse response = new GameResponse();

        //create response object
        response.setEnemyHp(GameConstants.BASE_ENEMY_HP);
        response.setPlayerHp(GameConstants.BASE_PLAYER_HP);
        response.setGameRound(1);
        response.setPlayerWon(false);
        response.setIsGameOver(false);

        return  response;
    }

    /**
     * Initializes the initial session for the game
     * @param session HttpSession object for user browser
     * @param game the initial game response for the new game
     */
    private void initGameSession(HttpSession session, GameResponse game, StartGameRequest startRequest){

        session.setAttribute(GameConstants.SESSION_GAMEROUNDS_KEY, game.getGameRound());
        session.setAttribute(GameConstants.SESSION_PLAYERHP_KEY,game.getPlayerHp());
        session.setAttribute(GameConstants.SESSION_ENEMYHP_KEY, game.getEnemyHp());
        session.setAttribute(GameConstants.SESSION_PLAYERWON_KEY, game.getPlayerWon());
        session.setAttribute(GameConstants.SESSION_GAMEDIFFICULTY_KEY, startRequest.getDifficultyCode());

    }

}
