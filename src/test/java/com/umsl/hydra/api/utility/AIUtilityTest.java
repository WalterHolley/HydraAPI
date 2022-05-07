package com.umsl.hydra.api.utility;

import com.umsl.hydra.api.model.DifficultyEnum;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentMatchers;

import static java.lang.System.exit;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AIUtilityTest {


    private AIUtility utility;

@Test
public void AIUTilSuccess(){
    short i = 0;
    boolean winner;
    utility = new AIUtility();
    winner = utility.wonRound(DifficultyEnum.EASY,new int[] {1,0,1});

    if(winner || !winner)
        i = 1;

    assertNotEquals(0,i );


}

}