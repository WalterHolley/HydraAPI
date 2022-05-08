package com.umsl.hydra.api.model;

public class HighScore {
    private String _playerName;
    private int _difficulty;
    private int _rounds;

    public void setPlayerName(String playerName){_playerName = playerName;}

    public void setDifficulty(int difficulty){_difficulty = difficulty;}

    public void setRounds(int rounds){_rounds = rounds;}

    public int getRounds(){return _rounds;}
    public String getPlayerName(){return _playerName;}
    public int getDifficulty(){return _difficulty;}
}
