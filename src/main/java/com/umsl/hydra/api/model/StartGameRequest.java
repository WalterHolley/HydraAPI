package com.umsl.hydra.api.model;

/**
 * StartGameRequest.java
 * model for starting a new game session
 */
public class StartGameRequest {
    private int difficultyCode;
    private DifficultyEnum _difficultyEnum;
    private String playerName;

    public void setDifficultyCode(int code){
        this.difficultyCode = code;

        if(code == 1)
            _difficultyEnum = DifficultyEnum.EASY;
        else if(code == 2)
            _difficultyEnum = DifficultyEnum.NORMAL;
        else
            _difficultyEnum = DifficultyEnum.HARD;

    }

    public void setPlayerName(String nameOfPlayer){
        this.playerName = nameOfPlayer;
    }

    public String getPlayerName(){
        return playerName;
    }


    /**
     *
     * @return Integer representation of difficulty code
     */
    public int getDifficultyCode(){
        return this.difficultyCode;
    }

    public DifficultyEnum getDifficultyEnum(){
        return  _difficultyEnum;
    }


}
