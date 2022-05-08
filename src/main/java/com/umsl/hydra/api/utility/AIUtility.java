package com.umsl.hydra.api.utility;
import com.umsl.hydra.api.model.DifficultyEnum;
import org.springframework.stereotype.Component;

import java.lang.Math;

@Component
public class AIUtility {

    public boolean wonRound(DifficultyEnum diff, int[] playerPattern){
        int[] enemyPattern;
        boolean result = false;

        enemyPattern = getEnemyPattern(diff, playerPattern);
        result = executeRound(playerPattern, enemyPattern);

        return result;
    }

    private int[] getEnemyPattern(DifficultyEnum difficulty, int[] playerPattern){
        int[] enemyPattern;

        switch(difficulty){
            case HARD:
                enemyPattern = getHardPattern(playerPattern);
                break;
            default:
                enemyPattern = getRandomPattern();
        }

        return enemyPattern;

    }

    /**
     * Implements the pattern selection algorithm from Penney's game
     * @param playerPattern the pattern provided by the player
     * @return array of the most likely pattern to win against the player's selection
     */
    private int[] getHardPattern(int[] playerPattern){
        int[] enemyPattern = playerPattern;
        int swap;
        enemyPattern[2] = enemyPattern[1];
        if(enemyPattern[1] == 0)
            swap = 1;
        else
            swap = 0;
        enemyPattern[0] = swap;

        return enemyPattern;

    }

    /**
     * Gets a random 3 integer(1 or 0) pattern
     * @return
     */
    private int[] getRandomPattern(){
        int[] gamePattern = new int[3];
        gamePattern[0] = (int) Math.floor(Math.random() * 2);
        gamePattern[1] = (int) Math.floor(Math.random() * 2);
        gamePattern[2] = (int) Math.floor(Math.random() * 2);

        return gamePattern;
    }

    /**
     * Plays a comparison game between two patterns
     * @param playerPattern The player's pattern
     * @param enemyPattern The enemy's pattern
     * @return true if the player pattern wins, otherwise false.
     */
    private boolean executeRound(int[] playerPattern, int[] enemyPattern){
        boolean isRunning = true;
        boolean result = false;

        int[] gamePattern = getRandomPattern();

        while(isRunning){
            //check for matching pattern
            if(patternsMatch(playerPattern, gamePattern)){
                isRunning = false;
                result = true;

            }
            else if(patternsMatch(enemyPattern, gamePattern)){
                isRunning = false;
                result = false;
            }
            else{
                //swap values
                gamePattern[0] = gamePattern[1];
                gamePattern[1] = gamePattern[2];
                gamePattern[2] = (int)Math.floor(Math.random() * 2);
            }
        }

        return result;
    }

    /**
     * Determines if two integer patterns match earch other
     * @param pattern1
     * @param pattern2
     * @return true if both patterns match.  otherwise false
     */
    private boolean patternsMatch(int[] pattern1, int[] pattern2){
        boolean result = true;
        if(pattern1.length != pattern2.length)
            result = false;
        else{
            for(int i = 0; i < pattern1.length; i++){
                if(pattern1[i] != pattern2[i]){
                    result = false;
                    break;
                }
            }
        }

        return result;
    }


}
