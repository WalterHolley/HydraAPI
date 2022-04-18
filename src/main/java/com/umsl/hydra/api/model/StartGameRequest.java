package com.umsl.hydra.api.model;

/**
 * StartGameRequest.java
 * model for starting a new game session
 */
public class StartGameRequest {
    private int _difficulty;
    private DifficultyEnum _difficultyEnum;

    public void setDifficultyCode(int code){
        this._difficulty = code;

        if(code == 1)
            _difficultyEnum = DifficultyEnum.EASY;
        else if(code == 2)
            _difficultyEnum = DifficultyEnum.NORMAL;
        else
            _difficultyEnum = DifficultyEnum.HARD;

    }

    /**
     *
     * @return Integer representation of difficulty code
     */
    public int getDifficultyCode(){
        return this._difficultyEnum.getDifficultyCode();
    }

    public DifficultyEnum getDifficultyEnum(){
        return  _difficultyEnum;
    }


}
