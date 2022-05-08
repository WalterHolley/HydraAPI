package com.umsl.hydra.api.model;

public class GameConstants {
    //Base game values
    public static final int BASE_PLAYER_HP = 5;
    public static final int BASE_ENEMY_HP = 5;
    public static final int BASE_ENEMY_ATK = 1;
    public static final int BASE_PLAYER_ATK = 1;
    public static final int BASE_PLAYER_HEAL = 2;

    //session keys
    public static final String SESSION_ENEMYHP_KEY = "enemyHp";
    public static final String SESSION_PLAYERHP_KEY = "playerHp";
    public static final String SESSION_GAMEROUNDS_KEY = "gameRound";
    public static final String SESSION_PLAYERWON_KEY = "playerWon";
    public static final String SESSION_GAMEDIFFICULTY_KEY = "difficulty";
    public static final String SESSION_GAMEOVER_KEY = "isGameOver";

}
