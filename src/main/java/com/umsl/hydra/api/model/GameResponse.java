package com.umsl.hydra.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * GameResponse.java
 * The response model for returning the result of
 * a game decision
 */
public class GameResponse {
    private int _playerHp;
    private int _enemyHp;
    private int _gameRound;
    private boolean _playerWon;
    private DifficultyEnum _difficulty;

    /**
     * Set value indicating if the player won the current round
     * @param playerWon boolean indicating round result
     */
    public void setPlayerWon(boolean playerWon){
        _playerWon = playerWon;
    }

    /**
     * Set a value for the player's HP
     * @param hp HP Value
     */
    public void setPlayerHp(int hp){
        _playerHp = hp;
    }

    /**
     * Set a value for the enemy HP
     * @param hp HP value
     */
    public void setEnemyHp(int hp){
        _enemyHp = hp;
    }

    /**
     * sets the count of game rounds that have passed
     * @param round the number of game rounds
     */
    @JsonIgnore
    public void setGameRound(int round){
        _gameRound = round;
    }

    /**
     * Sets the difficulty of the game
     * @param difficulty
     */
    @JsonIgnore
    public void setGameDifficulty(DifficultyEnum difficulty){
        _difficulty = difficulty;
    }

    /**
     * Retrieves HP of the player
     * @return HP Value
     */
    public int getPlayerHp(){
        return  _playerHp;
    }

    /**
     * Returns HP of the enemy
     * @return HP value
     */
    public int getEnemyHp(){
        return  _enemyHp;
    }

    /**
     * Returns the currently set round of the game
     * @return int of game round
     */
    @JsonIgnore
    public int getGameRound(){
        return  _gameRound;
    }

    /**
     * Returns the current difficulty setting
     * @return enum of game difficulty
     */
    @JsonIgnore
    public DifficultyEnum getDifficulty(){
        return _difficulty;
    }

    /**
     * Get boolean indicating result of the game round
     * @return true if player won the round.  otherwise false.
     */
    public boolean getPlayerWon(){
        return _playerWon;
    }


}
