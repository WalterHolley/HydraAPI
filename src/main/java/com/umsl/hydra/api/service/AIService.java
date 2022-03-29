package com.umsl.hydra.api.service;

import com.umsl.hydra.api.model.DifficultyEnum;

/*
AI Service - This is how the controller and
other services will interact with the game AI.
Use this area to gather needed information about the game session, then
pass that information along to the AI utility for performing the game decision.

You can also use this area to call on resources that need to be changed before or after
game AI functions.
 */
public class AIService {

    /**
     * Runs the Penney's game AI against the player's choices
     * @param playerCombo The three moves made by the player for the round
     * @param difficulty The game difficulty setting
     * @return True if player wins the round
     */
    public boolean getPlayerResult(String[] playerCombo, DifficultyEnum difficulty){

        boolean result = false;
        //call AI Utility to perform game decision
        if(difficulty.equals(DifficultyEnum.HARD)){
            //perform AI utility hard mode decision
        }

        return result;
    }
}
