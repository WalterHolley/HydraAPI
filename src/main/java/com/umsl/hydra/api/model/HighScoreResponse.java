package com.umsl.hydra.api.model;

import java.util.List;

public class HighScoreResponse {
    private List<HighScore> _highScores;

    public void setHighScoreList(List<HighScore> scoreList){
        _highScores = scoreList;
    }

    public void addScore(HighScore score){

    }

    private void sortScores(){

    }

    public List<HighScore> getHighScores(){return _highScores;}
}
