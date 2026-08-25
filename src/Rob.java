import java.util.Random;
import java.util.Scanner;

public class Rob {

    //pause
    void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void robGas(Character player, Scanner input, Random gen) {

        //Rolling Player Success
        int playerCheck = gen.nextInt(100) + 1;
        int moneyGained = gen.nextInt(1000, 5000) + 1;
        int moneyLost = gen.nextInt(0, 500) + 1;

        System.out.println("You walked into a gas station");
        pause(1000);

        //moneyCheck
        if (playerCheck <= 50) {
            System.out.println("You secretly checked the register and saw you could rob " + moneyGained + " dollars!");
        } else if (playerCheck > 50) {
            System.out.println("You failed to check the computer.");
        }

        pause(1000);

        System.out.println("Would you like to attempt to rob the gas station?");
        pause(1000);
        System.out.println("Yes or no?");

        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("yes")) {

            int gasPath1 = gen.nextInt(2) + 1;

            System.out.println("You successfully grab the money!");
            pause(2000);

            System.out.println("Oh shoot! There is a worker!!!");
            pause(1000);

            System.out.println("Would you like to choose the left or right path");

            String choiceLR1 = input.nextLine();

            if (choiceLR1.equalsIgnoreCase("left")) {

                int playerPath = gen.nextInt(2) + 1;

                pause(1000);

                if (gasPath1 == playerPath) {
                    System.out.println("You successfully made it out!");
                    pause(1000);
                    player.addMoney(moneyGained);
                } else {
                    System.out.println("You have not successfully made it out.");
                    pause(1000);
                    player.subtractMoney(moneyLost);
                }

            } else if (choiceLR1.equalsIgnoreCase("right")) {

                int playerPath = gen.nextInt(2) + 1;

                pause(1000);

                if (gasPath1 == playerPath) {
                    System.out.println("You successfully made it out!");
                    pause(1000);
                    player.addMoney(moneyGained);
                } else {
                    System.out.println("You have not successfully made it out.");
                    pause(1000);
                    player.subtractMoney(moneyLost);
                }
            }
        }
    }

    //end gas rob


    //start bank rob
    public void robBank(Character player, Scanner input, Random gen) {

        //Rolling Player Success
        int playerCheck = gen.nextInt(100) + 1;
        int moneyGained = gen.nextInt(10000, 50000) + 1;
        int moneyLost = gen.nextInt(1000, 5000) + 1;

        System.out.println("You snuck into a bank...");
        pause(1000);

        //moneyCheck
        if (playerCheck <= 40) {
            System.out.println("You found a bank note saying the vault has " + moneyGained + " dollars!");
        } else {
            System.out.println("You failed to find a bank note.");
        }

        pause(1000);

        System.out.println("Would you like to attempt to rob the bank?");
        pause(1000);
        System.out.println("Yes or no?");

        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("yes")) {

            System.out.println("You successfully break into the vault!");
            pause(2000);

            System.out.println("You spot night patrol around the corner!!!");
            pause(1000);

            System.out.println("Would you like to sprint left or right?");

            int gasPath1 = gen.nextInt(2) + 1;
            int gasPath2 = gen.nextInt(2) + 1;

            int playerPath1 = gen.nextInt(2) + 1;
            int playerPath2 = gen.nextInt(2) + 1;

            String choiceLR1 = input.nextLine();

            if (choiceLR1.equalsIgnoreCase("left")) {

                pause(1000);

                if (gasPath1 == playerPath1) {

                    System.out.println("You have made it through the first path... One more to go!");
                    pause(1000);

                    System.out.println("Would you like to sprint left or right?");

                    String choiceLR2 = input.nextLine();

                    if (choiceLR2.equalsIgnoreCase("left")
                            || choiceLR2.equalsIgnoreCase("right")) {

                        pause(1000);

                        if (playerPath2 == gasPath2) {
                            System.out.println("You successfully made it out!");
                            pause(1000);
                            player.addMoney(moneyGained);
                        } else {
                            System.out.println("You have not successfully made it out.");
                            pause(1000);
                            player.subtractMoney(moneyLost);
                        }
                    }

                } else {
                    System.out.println("You have not successfully made it out.");
                    pause(1000);
                    player.subtractMoney(moneyLost);
                }

            } else if (choiceLR1.equalsIgnoreCase("right")) {

                pause(1000);

                if (gasPath1 == playerPath1) {

                    System.out.println("You have made it through the first path... One more to go!");
                    pause(1000);

                    System.out.println("Would you like to sprint left or right?");

                    String choiceLR2 = input.nextLine();

                    if (choiceLR2.equalsIgnoreCase("left")
                            || choiceLR2.equalsIgnoreCase("right")) {

                        pause(1000);

                        if (playerPath2 == gasPath2) {
                            System.out.println("You successfully made it out!");
                            pause(1000);
                            player.addMoney(moneyGained);
                        } else {
                            System.out.println("You have not successfully made it out.");
                            pause(1000);
                            player.subtractMoney(moneyLost);
                        }
                    }

                } else {
                    System.out.println("You have not successfully made it out.");
                    pause(1000);
                    player.subtractMoney(moneyLost);
                }
            }
        }
    }

    //end bank rob

}
