package com.umsl.hydra.api.model;

public class HighScore implements  IDomainObject{
    private String _playerName;
    private int _difficulty;
    private int _rounds;
    private int _rank;
    private String id;

    public static final String OBJECT_KEY = "HISCORE";

    public HighScore(){

    }

    public HighScore(String id, int difficulty, int rounds, String playerName){
        this.id = id;
        this._difficulty = difficulty;
        this._rounds = rounds;
        this._playerName = playerName;
    }

    public void setPlayerName(String playerName){_playerName = playerName;}

    public void setDifficulty(int difficulty){_difficulty = difficulty;}

    public void setRounds(int rounds){_rounds = rounds;}

    public void setRank(int rank){_rank = rank;}

    public int getRounds(){return _rounds;}
    public String getPlayerName(){return _playerName;}
    public int getDifficulty(){return _difficulty;}
    public int getRank(){return _rank;}

    @Override
    public String getKey() {
        return id;
    }

    @Override
    public String getObjectKey() {
        return OBJECT_KEY;
    }
}
