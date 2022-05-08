package com.umsl.hydra.api.model;

/**
 * DifficultyEnum.java
 * an enumerated type that represents a game difficulty selection
 */
public enum DifficultyEnum {
    EASY(1),
    NORMAL(2),
    HARD(3);

    private int difficultyCode;
    private DifficultyEnum difficultyEnum;

    private DifficultyEnum(int difficultyCode){
        this.difficultyCode = difficultyCode;
    }

    public int getDifficultyCode(){
        return difficultyEnum.difficultyCode;
    }




}
