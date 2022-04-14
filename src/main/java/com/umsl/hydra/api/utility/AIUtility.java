package com.umsl.hydra.api.utility;
import java.util.Scanner;
import java.lang.Math;

public class AIUtility {

public static void roundstart(int difficulty){
int count = 0;
count++;
System.out.println("Round: " + count);

System.out.println("Please choose your 3 coin pattern: ");
Scanner scanner = new Scanner(System.in);
int first = scanner.nextInt();
int second = scanner.nextInt();
int third = scanner.nextInt();

System.out.println("Your pattern is: " + first + " " + second + " " + third);
    if (difficulty==0){

    }
    else if (difficulty==1){
        System.out.println("You have selected medium as your difficulty");
    }
    else {
        difficulty2(first, second, third);
    }
}

public static void difficulty0(int first, int second, int third){

}
public static void difficulty1(int first, int second, int third){

}
public static void difficulty2(int first, int second, int third){
int aifirst;
if(second==1) {
    aifirst = 2;
}
else{
    aifirst = 1;
}
int aisecond = first;
int aithird = second;

System.out.println("The hydras pattern is: " + aifirst + " " + aisecond + " " + aithird);

boolean seq = true;
    System.out.println("Randomly tossed coins: ");
    int cpat = 3;
    int pat1;
    int pat2;
    int pat3 = 0;
    int pat4 = 0;
    int pat5 = 0;
while(true) {
    pat1 = 0;
    pat2 = 0;
    if (cpat == 3) {
        pat3 = (int) (Math.random() * 2 + 1);
        pat4 = (int) (Math.random() * 2 + 1);
        pat5 = (int) (Math.random() * 2 + 1);
        System.out.print(pat3 + " " + pat4 + " " + pat5 + " ");
    }
    else if (cpat == 4) {
        pat1 = pat4;
        pat2 = pat5;
        pat3 = (int) (Math.random() * 2 + 1);
        pat4 = (int) (Math.random() * 2 + 1);
        pat5 = (int) (Math.random() * 2 + 1);
        System.out.print(pat3 + " " + pat4 + " " + pat5 + " ");
    }
    else if (cpat>5){
        pat1 = pat4;
        pat2 = pat5;
        pat3 = (int) (Math.random() * 2 + 1);
        pat4 = (int) (Math.random() * 2 + 1);
        pat5 = (int) (Math.random() * 2 + 1);
        System.out.print(pat3 + " " + pat4 + " " + pat5 + " ");
    }
    cpat++;
    if (pat1 == first && pat2 == second && pat3 == third) {
        System.out.println("");
        System.out.println("You have won this round");
        break;
    }
    else if (pat1 == aifirst && pat2 == aisecond && pat3 == aithird) {
        System.out.println("");
        System.out.println("The hydra won this round");
        break;
    }
    else if (pat2 == first && pat3 == second && pat4 == third) {
        System.out.println("");
        System.out.println("You have won this round");
        break;
    }
    else if (pat2 == aifirst && pat3 == aisecond && pat4 == aithird) {
        System.out.println("");
        System.out.println("The hydra won this round");
        break;
    }
    else if (pat3 == first && pat4 == second && pat5 == third) {
        System.out.println("");
        System.out.println("You have won this round");
        break;
    }
    else if (pat3 == aifirst && pat4 == aisecond && pat5 == aithird) {
        System.out.println("");
        System.out.println("The hydra won this round");
        break;
    }
}
}


public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
    System.out.print("Please select difficulty(0-2): ");
    int difficulty = scanner.nextInt();
        if (difficulty==0){
            System.out.println("You have selected easy as your difficulty");
        }
        else if (difficulty==1){
            System.out.println("You have selected medium as your difficulty");
        }
        else {
            System.out.println("You have selected hard as your difficulty");
        }
    roundstart(difficulty);

}
}
