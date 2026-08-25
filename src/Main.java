import java.util.*;
public class Main {

    public static void main(String[] args) {
        //util creation
        Scanner input = new Scanner(System.in);
        Random gen = new Random();
        boolean playing = true;

        //info creation
        Character player1 = new Character(0);


        //welcome
        System.out.println("Welcome to Andrew's lifesim project!");
        pause(1000);

        System.out.println("I started this project august 23 and it is currently in patch 2.2.0");
        pause(1000);

        System.out.println("");
        System.out.println("You currently have " + player1.getMoney() + " dollars");
        pause(1000);

        while (playing == true) {
            //choice begins
            boolean whileCasino = false;

            System.out.println("");
            System.out.println("What would you like to do now?");
            pause(500);

            System.out.println("Rob");
            pause(300);

            System.out.println("Casino");
            pause(500);

            String startCommand = input.nextLine();

            //add
            if (startCommand.equalsIgnoreCase("add")) {
                pause(500);

                player1.cheatMoney(10000);

                System.out.println("Total money is " + player1.getMoney() + " dollars");
                pause(1000);
            }


            //rob
            else if (startCommand.equalsIgnoreCase("Rob") && player1.getMoney() <= 10000) {
                System.out.println("What would you like to rob?");
                pause(1000);

                System.out.println("1. Gas Station");
                pause(500);

                System.out.println("2. Bank");

                String robCommand = input.nextLine();


                //gas rob
                if (robCommand.equalsIgnoreCase("Gas Station")) {
                    pause(1000);

                    System.out.println("You chose the gas station...");
                    pause(1000);

                    player1.robGas(input, gen);

                    pause(1000);

                    System.out.println("You now have " + player1.getMoney() + " dollars");
                    pause(1000);
                }

                //bank rob
                if (robCommand.equalsIgnoreCase("Bank")) {
                    pause(1000);

                    System.out.println("You chose the bank...");
                    pause(1500);

                    player1.robBank(input, gen);

                    pause(1000);

                    System.out.println("You now have " + player1.getMoney() + " dollars");
                    pause(1000);
                }
            }

            if (startCommand.equalsIgnoreCase("Rob") && player1.getMoney() > 10000) {
                pause(500);

                System.out.println("Sorry ya got too much money hit the casino");
                pause(1000);
            }

            //end rob

            //start casino

            else if (startCommand.equalsIgnoreCase("Casino")) {
                pause(1000);

                System.out.println("You walk into the casino...");
                pause(1500);

                while (whileCasino == false) {
                    //casino choices
                    System.out.println("");
                    System.out.println("Which game would you like to play?");
                    pause(1000);

                    System.out.println("1. Coin Flip");
                    pause(400);

                    System.out.println("2. Blackjack");
                    pause(400);

                    System.out.println("3. Horse Racing");
                    pause(400);

                    System.out.println("4. Leave");

                    String choiceCommand = input.nextLine();

                    //coin flip
                    if (choiceCommand.equalsIgnoreCase("Coin Flip")) {
                        pause(700);

                        System.out.println("You walk over to the coin flip table...");
                        pause(1000);

                        player1.casinoCoin(input, gen);

                        pause(1000);
                    }

                    //blackjack
                    else if (choiceCommand.equalsIgnoreCase("Blackjack")) {
                        pause(700);

                        System.out.println("You sit down at the blackjack table...");
                        pause(1200);

                        player1.blackjack(input, gen);

                        pause(1000);
                    }

                    //horse racing
                    else if (choiceCommand.equalsIgnoreCase("Horse Racing")) {
                        pause(700);
                        player1.horseRacing(input, gen);
                        pause(1000);
                    }

                    //leave
                    else if (choiceCommand.equalsIgnoreCase("Leave")) {
                        pause(500);

                        System.out.println("Sad to see you go! Come Again soon!");
                        pause(1000);

                        whileCasino = true;
                    }

                    //invalid
                    else {
                        System.out.println("Sorry, that is not a valid choice.");
                        pause(1000);
                    }
                }



                //end casino
            }
        }
    }

//PAUSE

    static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}