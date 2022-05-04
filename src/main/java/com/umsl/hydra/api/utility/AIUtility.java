package com.umsl.hydra.api.utility;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class AIUtility {
    public static int[] roundstart(int hydrahp, int playerhp, int count, char playagain) {
        int[] again = new int[1];
        if (hydrahp == 0) {
            System.out.println("Congradulations! You beat the hydra in " + count + " rounds!");
            boolean valid = true;
            while (valid) {
                System.out.println("Would you like to play again? (y/n):");
                try {
                    if (playagain == 'y'){
                        again[0] = 1;
                        return again;
                    }
                    else if (playagain == 'n') {
                        again[0] = 0;
                        return again;
                    }
                    else
                        System.out.println("please enter a y or n");
                } catch (InputMismatchException exception) {
                    System.out.println("Invalid, please enter a y or n: ");
                }
            }
        } else if (playerhp == 0) {
            System.out.println("The hydra has bested you. You survived " + count + " rounds against the beast.");
            boolean valid = true;
            while (valid) {
                System.out.println("Would you like to play again? (y/n):");
                try {
                    if (playagain == 'y'){
                        again[0] = 1;
                        return again;
                    }
                    else if (playagain == 'n') {
                        again[0] = 0;
                        return again;
                    }
                    else
                        System.out.println("please enter a y or n");
                } catch (InputMismatchException exception) {
                    System.out.println("Invalid, please enter a y or n: ");
                }
            }
        }
        count++;
        System.out.println("\nRound: " + count);
        System.out.println("Your health: " + playerhp);
        System.out.println("Hydra health: " + hydrahp);

        int[] roundstart = new int[3];
        roundstart[0] = hydrahp;
        roundstart[1] = playerhp;
        roundstart[2] = count;
        return roundstart;
    }

    public static int[] difficulty0(int hydrahp, int playerhp, int first, int second, int third, int move) {
        System.out.println("The hydra will pick its pattern first.");
        int aifirst = (int) (Math.random() * 2 + 1);
        int aisecond = (int) (Math.random() * 2 + 1);
        int aithird = (int) (Math.random() * 2 + 1);
        System.out.println("The hydras pattern is: " + aifirst + " " + aisecond + " " + aithird);

        System.out.println("Now pick your pattern: ");
        boolean valid = true;
        while (valid) {
            try {
                if ((first != 1 && first != 2) || (second != 1 && second != 2) || (third != 1 && third != 2)) {
                    System.out.println("Invalid, please ensure all numbers are a 1 or 2: ");
                }else
                    break;
            } catch (InputMismatchException exception) {
                System.out.println("Invalid, please ensure all numbers are a 1 or 2: ");
            }
        }
                System.out.println("Your pattern is: " + first + " " + second + " " + third);
                System.out.println("Randomly tossed coins: ");
                int cpat = 3;
                int pat1;
                int pat2;
                int pat3 = 0;
                int pat4 = 0;
                int pat5 = 0;
                int win;
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
            valid = true;
            while (valid) {
                try {
                    System.out.println("1) Attack the hydra for 10 hp");
                    if (playerhp <= 90) {
                        System.out.println("2) Heal for 10 hp");
                        System.out.println("What is your move(1 or 2):");
                        if (move != 1 && move != 2)
                            System.out.println("Please enter a 1 or 2: ");
                        else {
                            valid = false;
                            if (move == 1)
                                hydrahp = hydrahp - 10;
                            else
                                playerhp = playerhp + 10;
                        }
                    } else if (playerhp <= 95) {
                        System.out.println("2) Heal for 5 hp");
                        System.out.println("What is your move(1 or 2):");
                        if (move != 1 && move != 2)
                            System.out.println("Please enter a 1 or 2: ");
                        else {
                            valid = false;
                            if (move == 1)
                                hydrahp = hydrahp - 10;
                            else
                                playerhp = playerhp + 5;
                        }
                    } else {
                        if (move != 1)
                            System.out.println("Please enter a 1 or 2: ");
                        else {
                            valid = false;
                            if (move == 1)
                                hydrahp = hydrahp - 10;
                        }
                    }

                } catch (InputMismatchException exception) {
                    System.out.println("Invalid, please enter a 1: ");

                }

            }

        } else {
            System.out.println("The hydra has attacked you for 5 damage");
            playerhp = playerhp - 25;
        }
        int[] difficulty0 = new int[2];
        difficulty0[0] = playerhp;
        difficulty0[1] = hydrahp;
        return difficulty0;
        }

    public static int[] difficulty1(int hydrahp, int playerhp, int first, int second, int third, int move) {
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
            boolean valid = true;
            while (valid) {
                try {
                    System.out.println("1) Attack the hydra for 10 hp");
                    if (playerhp <= 90) {
                        System.out.println("2) Heal for 10 hp");
                        System.out.println("What is your move(1 or 2):");
                        if (move != 1 && move != 2)
                            System.out.println("Please enter a 1 or 2: ");
                        else {
                            valid = false;
                            if (move == 1)
                                hydrahp = hydrahp - 10;
                            else
                                playerhp = playerhp + 10;
                        }
                    } else if (playerhp <= 95) {
                        System.out.println("2) Heal for 5 hp");
                        System.out.println("What is your move(1 or 2):");
                        if (move != 1 && move != 2)
                            System.out.println("Please enter a 1 or 2: ");
                        else {
                            valid = false;
                            if (move == 1)
                                hydrahp = hydrahp - 10;
                            else
                                playerhp = playerhp + 5;
                        }
                    } else {
                        if (move != 1)
                            System.out.println("Please enter a 1: ");
                        else {
                            valid = false;
                            if (move == 1)
                                hydrahp = hydrahp - 10;
                        }
                    }

                } catch (InputMismatchException exception) {
                    System.out.println("Invalid, please enter a valid input: ");

                }

            }

        } else {
            System.out.println("The hydra has attacked you for 5 damage");
            playerhp = playerhp - 25;
        }
        int[] difficulty1 = new int[2];
        difficulty1[0] = playerhp;
        difficulty1[1] = hydrahp;
        return difficulty1;
    }
    public static int[] difficulty2(int hydrahp, int playerhp, int first, int second, int third, int move) {
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
            boolean valid = true;
            while (valid) {
                try {
                    System.out.println("1) Attack the hydra for 10 hp");
                    if (playerhp <= 90) {
                        System.out.println("2) Heal for 10 hp");
                        System.out.println("What is your move(1 or 2):");
                        if (move != 1 && move != 2)
                            System.out.println("Please enter a 1 or 2: ");
                        else {
                            valid = false;
                            if (move == 1)
                                hydrahp = hydrahp - 10;
                            else
                                playerhp = playerhp + 10;
                        }
                    } else if (playerhp <= 95) {
                        System.out.println("2) Heal for 5 hp");
                        System.out.println("What is your move(1 or 2):");
                        if (move != 1 && move != 2)
                            System.out.println("Please enter a 1 or 2: ");
                        else {
                            valid = false;
                            if (move == 1)
                                hydrahp = hydrahp - 10;
                            else
                                playerhp = playerhp + 5;
                        }
                    } else {
                        if (move != 1)
                            System.out.println("Please enter a 1: ");
                        else {
                            valid = false;
                            if (move == 1)
                                hydrahp = hydrahp - 10;
                        }
                    }

                } catch (InputMismatchException exception) {
                    System.out.println("Invalid, please enter a 1 or 2: ");

                }

            }

        } else {
            System.out.println("The hydra has attacked you for 5 damage");
            playerhp = playerhp - 25;
        }
        int[] difficulty2 = new int[2];
        difficulty2[0] = playerhp;
        difficulty2[1] = hydrahp;
        return difficulty2;
    }

    public static int[] driver(int difficulty) {
        int hydrahp = 100;
        int playerhp = 100;
        int count = 0;
        boolean valid = true;
        while (valid) {
            try {
                    if (difficulty < 3 && difficulty >= 0) {
                        if (difficulty == 0) {
                            System.out.println("You have selected easy as your difficulty");
                        } else if (difficulty == 1) {
                            System.out.println("You have selected medium as your difficulty");
                        } else {
                            System.out.println("You have selected hard as your difficulty");
                        }
                        valid = false;
                    }
                    else
                        System.out.println("Please enter 0, 1, or 2 to select your difficulty: ");
            }
            catch (InputMismatchException exception) {
                System.out.println("Invalid, please enter a number between 0 and 2: ");
            }
        }
        int[] driver = new int[3];
        driver[0] = hydrahp;
        driver[1] = playerhp;
        driver[2] = count;
    return driver;
    }
}
