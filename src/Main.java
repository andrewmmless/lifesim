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
        System.out.println("I started this project august 23 and it is currently in patch 2.2.0");
        System.out.println("");
        System.out.println("You currently have " + player1.getMoney() + " dollars");

        while (playing = true) {
            //choice begins
            boolean whileCasino = false;
            System.out.println("What would you like to do now?");
            System.out.println("Rob");
            System.out.println("Casino");
            String startCommand = input.nextLine();

            if (startCommand.equalsIgnoreCase("add")) {
                player1.cheatMoney(10000);
                System.out.println("Total money is " + player1.getMoney());
            }


            //rob
            else if (startCommand.equalsIgnoreCase("Rob") && player1.getMoney() <= 10000) {
                System.out.println("What would you like to rob?");
                pause(1000);
                System.out.println("1. Gas Station");
                System.out.println("2. Bank");

                String robCommand = input.nextLine();


                //gas rob
                if (robCommand.equalsIgnoreCase("Gas Station")) {
                    player1.robGas(input, gen);
                    System.out.println("You now have " + player1.getMoney() + " dollars");
                }

                //bank rob
                if (robCommand.equalsIgnoreCase("Bank")) {
                    player1.robBank(input, gen);
                    System.out.println("You now have " + player1.getMoney() + " dollars");
                }
            }
            if (startCommand.equalsIgnoreCase("Rob") && player1.getMoney() > 10000) {
                System.out.println("Sorry ya go too much money hit the casino");
            }
            //end rob

            //start casino

            else if (startCommand.equalsIgnoreCase("Casino")) {
                while (whileCasino == false) {
                    //casino choices
                    System.out.println("Which game would you like to play?");
                    pause(1000);
                    System.out.println("1. Coin Flip");
                    System.out.println("2. Blackjack");
                    System.out.println("3. Leave");
                    String choiceCommand = input.nextLine();

                    //coin flip
                    if (choiceCommand.equalsIgnoreCase("Coin Flip")) {
                        player1.casinoCoin(input, gen);
                    } else if (choiceCommand.equalsIgnoreCase("Blackjack")) {
                        player1.blackjack(input, gen);
                    } else if (choiceCommand.equalsIgnoreCase("Leave")) {
                        System.out.println("Sad to see you go! Come Again soon!");
                        whileCasino = true;
                    }
                    else {
                        System.out.println("Sorry, that is not a valid choice.");
                    }
                }

                //end casino
            }
        }
    }
//PAUSE


        static void pause (int milliseconds){
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
