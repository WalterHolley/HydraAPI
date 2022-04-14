package com.umsl.hydra.api.model;

public enum DifficultyEnum {
    EASY(1),
    NORMAL(2),
    HARD(3);

    private final int difficultyCode;

    private DifficultyEnum(int difficultyCode){
        this.difficultyCode = difficultyCode;
    }

    public int getDifficultyCode(){
        return this.difficultyCode;
    }


}
