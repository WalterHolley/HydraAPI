package com.umsl.hydra.api.model;

/**
 * GameResponse
 * The response model for returning the result of
 * a game decision
 */
public class GameResponse {
    private int _playerHp;
    private int _enemyHp;
    private boolean _playerWon;

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
     * Get boolean indicating result of the game round
     * @return true if player won the round.  otherwise false.
     */
    public boolean getPlayerWon(){
        return _playerWon;
    }


}
