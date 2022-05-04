package com.umsl.hydra.api.utility;

public class AIUtilityLib {
    public static void main(String[] args) {


    AIUtility library = new AIUtility();
    int difficulty = 0;
    int hydrahplib, playerhplib, countlib;
    int first = 1, second = 1, third = 2, move = 1;
    char playagainlib = 'n';
    int[] driverlib;
    driverlib = library.driver(difficulty);
    hydrahplib = driverlib[0];
    playerhplib = driverlib[1];
    countlib = driverlib[2];
    int[] libarr;
    while (true) {
        libarr = library.roundstart(hydrahplib, playerhplib, countlib, playagainlib);
        hydrahplib = libarr[0];
        playerhplib = libarr[1];
        countlib = libarr[2];

        if (hydrahplib == 0 || playerhplib == 0)
            break;

        if (difficulty == 0){
            hydrahplib = library.difficulty0(hydrahplib, playerhplib, first, second, third, move)[0];
            playerhplib = library.difficulty0(hydrahplib, playerhplib, first, second, third, move)[1];
            countlib = library.difficulty0(hydrahplib, playerhplib, first, second, third, move)[2];
        }
        else if (difficulty == 1){
            hydrahplib = library.difficulty1(hydrahplib, playerhplib, first, second, third, move)[0];
            playerhplib = library.difficulty1(hydrahplib, playerhplib, first, second, third, move)[1];
            countlib = library.difficulty1(hydrahplib, playerhplib, first, second, third, move)[2];
        }
        else if (difficulty == 2){
            hydrahplib = library.difficulty2(hydrahplib, playerhplib, first, second, third, move)[0];
            playerhplib = library.difficulty2(hydrahplib, playerhplib, first, second, third, move)[1];
            countlib = library.difficulty2(hydrahplib, playerhplib, first, second, third, move)[2];
        }
    }
}
}
