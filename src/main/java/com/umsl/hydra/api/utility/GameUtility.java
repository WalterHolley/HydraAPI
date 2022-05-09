package com.umsl.hydra.api.utility;

import com.umsl.hydra.api.model.DifficultyEnum;
import org.springframework.stereotype.Component;

@Component
public class GameUtility {

    public DifficultyEnum getDifficultyByCode(int code){
        DifficultyEnum difficultyEnum;

        switch(code){
            case 1:
                difficultyEnum = DifficultyEnum.EASY;
                break;
            case 2:
                difficultyEnum = DifficultyEnum.NORMAL;
                break;
            case 3:
                difficultyEnum = DifficultyEnum.HARD;
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty code");
        }

        return difficultyEnum;
    }

    public int getCodeByDifficulty(DifficultyEnum difficultyEnum){
        int result;
        switch (difficultyEnum){
            case EASY:
                result = 1;
                break;
            case NORMAL:
                result = 2;
                break;
            default:
                result = 3;
        }

        return result;
    }
}
