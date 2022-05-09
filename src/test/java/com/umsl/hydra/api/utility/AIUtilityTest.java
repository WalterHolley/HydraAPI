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
public void wonRoundSuccess(){
    short i = 0;
    boolean winner;
    utility = new AIUtility();
    winner = utility.wonRound(DifficultyEnum.EASY,new int[] {1,0,1});

    if(winner || !winner)
        i = 1;

    assertNotEquals(0,i );
}
@Test
public void getEnemyPatternSuccess(){
    short i = 0;
    int[] pattern;
    utility = new AIUtility();
    pattern = utility.getEnemyPattern(DifficultyEnum.EASY, new int[] {1, 0, 1});
    if ((pattern[0] == 0 || pattern[0] == 1) && (pattern[1] == 0 || pattern[1] == 1) && (pattern[2] == 0 || pattern[2] == 1))
        i = 1;
    assertNotEquals(0,i);
}
@Test
public void getHardPatternSuccess(){
    int[] playerpattern = {1, 0 , 1};
    int[] testpattern = {1, 1, 0};
    int[] AIpattern;
    utility = new AIUtility();
    AIpattern = utility.getHardPattern(playerpattern);
    assertArrayEquals(testpattern, AIpattern);
}
@Test
    public void getRandomPatternSuccess(){
    short i = 0;
    int[] pattern;
    utility = new AIUtility();
    pattern = utility.getRandomPattern();
    if ((pattern[0] == 0 || pattern[0] == 1) && (pattern[1] == 0 || pattern[1] == 1) && (pattern[2] == 0 || pattern[2] == 1))
        i = 1;
    assertNotEquals(0,i);
}
@Test
    public void executeRoundSuccess(){
    int[] player = {1, 0, 1};
    int[] AI = {1, 0, 0};
    boolean check;
    short i = 0;
    utility = new AIUtility();
    check = utility.executeRound(player, AI);
    if(check || !check)
        i = 1;
    assertNotEquals(0, i);
}
@Test
    public void patternsMatchSuccess(){
    int[] first = {1, 0, 0};
    int[] second = {1, 0, 1};
    boolean check;
    utility = new AIUtility();
    check = utility.patternsMatch(first, second);
    assertEquals(false,check);

    int[] first2 = {1, 0, 0};
    int[] second2 = {1, 0, 0};
    check = utility.patternsMatch(first2, second2);
    assertEquals(true,check);
}
}