package com.umsl.hydra.api.utility;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class AIUtility {
    public static void playagain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play again? (y/n):");
        char playagain = scanner.next().charAt(0);
        if (playagain == 'y')
            main(null);
        else
            System.exit(0);

    }

    public static void roundstart(int difficulty, int hydrahp, int playerhp, int count) {
        if (hydrahp == 0) {
            System.out.println("Congradulations! You beat the hydra in " + count + " rounds!");
            playagain();
        } else if (playerhp == 0) {
            System.out.println("The hydra has bested you. You survived " + count + " rounds against the beast.");
            playagain();
        }
        count++;
        System.out.println("\nRound: " + count);
        System.out.println("Your health: " + playerhp);
        System.out.println("Hydra health: " + hydrahp);
        if (difficulty == 1 || difficulty == 2) {
            System.out.println("Please choose your 3 coin pattern: ");
            Scanner scanner = new Scanner(System.in);
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            int third = scanner.nextInt();

            System.out.println("Your pattern is: " + first + " " + second + " " + third);
             if (difficulty == 1) {
                difficulty1(first, second, third, hydrahp, playerhp, difficulty, count);
            } else {
                difficulty2(first, second, third, hydrahp, playerhp, difficulty, count);
            }
        } else {
                difficulty0(hydrahp, playerhp, difficulty, count);
        }
    }

    public static void difficulty0(int hydrahp, int playerhp, int difficulty, int count) {
       System.out.println("The hydra will pick its pattern first.");
        int aifirst = (int) (Math.random() * 2 + 1);
        int aisecond = (int) (Math.random() * 2 + 1);
        int aithird = (int) (Math.random() * 2 + 1);
       System.out.println("The hydras pattern is: " + aifirst + " " + aisecond + " " + aithird);

       System.out.println("Now pick your pattern: ");
       Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();

        System.out.println("Your pattern is: " + first + " " + second + " " + third);
        System.out.println("Randomly tossed coins: ");
        int cpat = 3;
        int pat1;
        int pat2;
        int pat3 = 0;
        int pat4 = 0;
        int pat5 = 0;
        int win = 0;
        while (true) {
            pat1 = 0;
            pat2 = 0;
            if (cpat == 3) {
                pat3 = (int) (Math.random() * 2 + 1);
                pat4 = (int) (Math.random() * 2 + 1);
                pat5 = (int) (Math.random() * 2 + 1);
                System.out.print(pat3 + " " + pat4 + " " + pat5 + " ");
            } else if (cpat == 4) {
                pat1 = pat4;
                pat2 = pat5;
                pat3 = (int) (Math.random() * 2 + 1);
                pat4 = (int) (Math.random() * 2 + 1);
                pat5 = (int) (Math.random() * 2 + 1);
                System.out.print(pat3 + " " + pat4 + " " + pat5 + " ");
            } else if (cpat > 5) {
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
                win = 0;
                break;
            } else if (pat1 == aifirst && pat2 == aisecond && pat3 == aithird) {
                System.out.println("");
                System.out.println("The hydra won this round");
                win = 1;
                break;
            } else if (pat2 == first && pat3 == second && pat4 == third) {
                System.out.println("");
                System.out.println("You have won this round");
                win = 0;
                break;
            } else if (pat2 == aifirst && pat3 == aisecond && pat4 == aithird) {
                System.out.println("");
                System.out.println("The hydra won this round");
                win = 1;
                break;
            } else if (pat3 == first && pat4 == second && pat5 == third) {
                System.out.println("");
                System.out.println("You have won this round");
                win = 0;
                break;
            } else if (pat3 == aifirst && pat4 == aisecond && pat5 == aithird) {
                System.out.println("");
                System.out.println("The hydra won this round");
                win = 1;
                break;
            }
        }
        if (win == 0) {
            System.out.println("You have won and can choose a move");
            System.out.println("Moves:");
            System.out.println("1) Attack the hydra for 10 hp");
            if (playerhp <= 90) {
                System.out.println("2) Heal for 10 hp");
                System.out.println("What is your move(1 or 2):");
                int move = scanner.nextInt();
                if (move == 1)
                    hydrahp = hydrahp - 10;
                else
                    playerhp = playerhp + 10;
            } else if (playerhp <= 95) {
                System.out.println("2) Heal for 10 hp");
                System.out.println("What is your move(1 or 2):");
                int move = scanner.nextInt();
                if (move == 1)
                    hydrahp = hydrahp - 10;
                else
                    playerhp = playerhp + 5;
            }

        } else {
            System.out.println("The hydra has attacked you for 5 damage");
            playerhp = playerhp - 10;
        }
        roundstart(difficulty, hydrahp, playerhp, count);
    }
    public static void difficulty1(int first, int second, int third, int hydrahp, int playerhp, int difficulty, int count) {
        Scanner scanner = new Scanner(System.in);
        int aifirst = (int) (Math.random() * 2 + 1);
        int aisecond = (int) (Math.random() * 2 + 1);
        int aithird = (int) (Math.random() * 2 + 1);
        System.out.println("The hydras pattern is: " + aifirst + " " + aisecond + " " + aithird);
        System.out.println("Randomly tossed coins: ");
        int cpat = 3;
        int pat1;
        int pat2;
        int pat3 = 0;
        int pat4 = 0;
        int pat5 = 0;
        int win = 0;
        while (true) {
            pat1 = 0;
            pat2 = 0;
            if (cpat == 3) {
                pat3 = (int) (Math.random() * 2 + 1);
                pat4 = (int) (Math.random() * 2 + 1);
                pat5 = (int) (Math.random() * 2 + 1);
                System.out.print(pat3 + " " + pat4 + " " + pat5 + " ");
            } else if (cpat == 4) {
                pat1 = pat4;
                pat2 = pat5;
                pat3 = (int) (Math.random() * 2 + 1);
                pat4 = (int) (Math.random() * 2 + 1);
                pat5 = (int) (Math.random() * 2 + 1);
                System.out.print(pat3 + " " + pat4 + " " + pat5 + " ");
            } else if (cpat > 5) {
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
                win = 0;
                break;
            } else if (pat1 == aifirst && pat2 == aisecond && pat3 == aithird) {
                System.out.println("");
                System.out.println("The hydra won this round");
                win = 1;
                break;
            } else if (pat2 == first && pat3 == second && pat4 == third) {
                System.out.println("");
                System.out.println("You have won this round");
                win = 0;
                break;
            } else if (pat2 == aifirst && pat3 == aisecond && pat4 == aithird) {
                System.out.println("");
                System.out.println("The hydra won this round");
                win = 1;
                break;
            } else if (pat3 == first && pat4 == second && pat5 == third) {
                System.out.println("");
                System.out.println("You have won this round");
                win = 0;
                break;
            } else if (pat3 == aifirst && pat4 == aisecond && pat5 == aithird) {
                System.out.println("");
                System.out.println("The hydra won this round");
                win = 1;
                break;
            }
        }
        if (win == 0) {
            System.out.println("You have won and can choose a move");
            System.out.println("Moves:");
            System.out.println("1) Attack the hydra for 10 hp");
            if (playerhp <= 90) {
                System.out.println("2) Heal for 10 hp");
                System.out.println("What is your move(1 or 2):");
                int move = scanner.nextInt();
                if (move == 1)
                    hydrahp = hydrahp - 10;
                else
                    playerhp = playerhp + 10;
            } else if (playerhp <= 95) {
                System.out.println("2) Heal for 10 hp");
                System.out.println("What is your move(1 or 2):");
                int move = scanner.nextInt();
                if (move == 1)
                    hydrahp = hydrahp - 10;
                else
                    playerhp = playerhp + 5;
            }

        } else {
            System.out.println("The hydra has attacked you for 5 damage");
            playerhp = playerhp - 10;
        }
        roundstart(difficulty, hydrahp, playerhp, count);
    }
    public static void difficulty2(int first, int second, int third, int hydrahp, int playerhp, int difficulty, int count) {
        Scanner scanner = new Scanner(System.in);
        int aifirst;
        if (second == 1) {
            aifirst = 2;
        } else {
            aifirst = 1;
        }
        int aisecond = first;
        int aithird = second;

        System.out.println("The hydras pattern is: " + aifirst + " " + aisecond + " " + aithird);
        System.out.println("Randomly tossed coins: ");
        int cpat = 3;
        int pat1;
        int pat2;
        int pat3 = 0;
        int pat4 = 0;
        int pat5 = 0;
        int win = 0;
        while (true) {
            pat1 = 0;
            pat2 = 0;
            if (cpat == 3) {
                pat3 = (int) (Math.random() * 2 + 1);
                pat4 = (int) (Math.random() * 2 + 1);
                pat5 = (int) (Math.random() * 2 + 1);
                System.out.print(pat3 + " " + pat4 + " " + pat5 + " ");
            } else if (cpat == 4) {
                pat1 = pat4;
                pat2 = pat5;
                pat3 = (int) (Math.random() * 2 + 1);
                pat4 = (int) (Math.random() * 2 + 1);
                pat5 = (int) (Math.random() * 2 + 1);
                System.out.print(pat3 + " " + pat4 + " " + pat5 + " ");
            } else if (cpat > 5) {
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
                win = 0;
                break;
            } else if (pat1 == aifirst && pat2 == aisecond && pat3 == aithird) {
                System.out.println("");
                System.out.println("The hydra won this round");
                win = 1;
                break;
            } else if (pat2 == first && pat3 == second && pat4 == third) {
                System.out.println("");
                System.out.println("You have won this round");
                win = 0;
                break;
            } else if (pat2 == aifirst && pat3 == aisecond && pat4 == aithird) {
                System.out.println("");
                System.out.println("The hydra won this round");
                win = 1;
                break;
            } else if (pat3 == first && pat4 == second && pat5 == third) {
                System.out.println("");
                System.out.println("You have won this round");
                win = 0;
                break;
            } else if (pat3 == aifirst && pat4 == aisecond && pat5 == aithird) {
                System.out.println("");
                System.out.println("The hydra won this round");
                win = 1;
                break;
            }
        }
        if (win == 0) {
            System.out.println("You have won and can choose a move");
            System.out.println("Moves:");
            System.out.println("1) Attack the hydra for 10 hp");
            if (playerhp <= 90) {
                System.out.println("2) Heal for 10 hp");
                System.out.println("What is your move(1 or 2):");
                int move = scanner.nextInt();
                if (move == 1)
                    hydrahp = hydrahp - 10;
                else
                    playerhp = playerhp + 10;
            } else if (playerhp <= 95) {
                System.out.println("2) Heal for 10 hp");
                System.out.println("What is your move(1 or 2):");
                int move = scanner.nextInt();
                if (move == 1)
                    hydrahp = hydrahp - 10;
                else
                    playerhp = playerhp + 5;
            }

        } else {
            System.out.println("The hydra has attacked you for 5 damage");
            playerhp = playerhp - 10;
        }
        roundstart(difficulty, hydrahp, playerhp, count);
    }


    public static void main(String[] args) {
        System.out.print("Please select difficulty(0-2): ");
        int difficulty = 0;
        boolean valid = true;
        while (valid) {
            try {
                Scanner scanner = new Scanner(System.in);
                difficulty = scanner.nextInt();
                    if (difficulty < 3 && difficulty >= 0) {
                        if (difficulty == 0) {
                            System.out.println("You have selected easy as your difficulty");
                        } else if (difficulty == 1) {
                            System.out.println("You have selected medium as your difficulty");
                        } else {
                            System.out.println("You have selected hard as your difficulty");
                        }
                        int hydrahp = 100;
                        int playerhp = 100;
                        int count = 0;
                        valid = false;
                        roundstart(difficulty, hydrahp, playerhp, count);

                    }
                    else
                        System.out.println("Please enter 0, 1, or 2 to select your difficulty: ");
            }
            catch (InputMismatchException exception) {
                System.out.println("Invalid, please enter a number between 0 and 2: ");
            }
        }
    }
}
