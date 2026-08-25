import java.util.Random;
import java.util.Scanner;

//class
public class Character {

    //pause
    void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int money;

    //character
    public Character(int money) {
        this.money = money;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void subtractMoney(int amount) {
        money -= amount;
    }

    public int getMoney() {
        return money;
    }

    //cheat
    public void cheatMoney(int money) {
        this.money += money;
    }

    //draw card
    private int drawCard(Random gen) {
        int card = gen.nextInt(13) + 1;

        if (card > 10) {
            card = 10;
        }

        return card;
    }

    //ace method
    private int addBlackjackCard(int total, int card, int[] aceCount) {

        if (card == 1) {
            aceCount[0]++;
            total += 11;
        } else {
            total += card;
        }

        //change ace from 11 to 1 if needed
        while (total > 21 && aceCount[0] > 0) {
            total -= 10;
            aceCount[0]--;
        }

        return total;
    }

    //card display
    private void displayCard(String player, int card) {

        if (card == 1) {
            System.out.println(player + " card is an Ace");
        } else {
            System.out.println(player + " card is a " + card);
        }
    }

    //start gas rob
    public void robGas(Scanner input, Random gen) {

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
                    addMoney(moneyGained);
                } else {
                    System.out.println("You have not successfully made it out.");
                    pause(1000);
                    subtractMoney(moneyLost);
                }

            } else if (choiceLR1.equalsIgnoreCase("right")) {

                int playerPath = gen.nextInt(2) + 1;

                pause(1000);

                if (gasPath1 == playerPath) {
                    System.out.println("You successfully made it out!");
                    pause(1000);
                    addMoney(moneyGained);
                } else {
                    System.out.println("You have not successfully made it out.");
                    pause(1000);
                    subtractMoney(moneyLost);
                }
            }
        }
    }

    //end gas rob


    //start bank rob
    public void robBank(Scanner input, Random gen) {

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
                            addMoney(moneyGained);
                        } else {
                            System.out.println("You have not successfully made it out.");
                            pause(1000);
                            subtractMoney(moneyLost);
                        }
                    }

                } else {
                    System.out.println("You have not successfully made it out.");
                    pause(1000);
                    subtractMoney(moneyLost);
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
                            addMoney(moneyGained);
                        } else {
                            System.out.println("You have not successfully made it out.");
                            pause(1000);
                            subtractMoney(moneyLost);
                        }
                    }

                } else {
                    System.out.println("You have not successfully made it out.");
                    pause(1000);
                    subtractMoney(moneyLost);
                }
            }
        }
    }

    //end bank rob


    //start casino


    //start flip a coin
    public void casinoCoin(Scanner input, Random gen) {

        //KICKED OUT CHECK
        if (getMoney() <= 0) {
            System.out.println("You have no money! The casino kicks you out.");
            pause(1000);
            return;
        }

        System.out.println("You currently got " + getMoney() + " dollars!");
        pause(700);

        System.out.println("How much would you like to wager or type 0 to know how the game works.");

        int wager = input.nextInt();
        String apple = input.nextLine();

        //wager check
        if (wager < 0) {
            System.out.println("You can not wager a negative amount.");
            pause(1000);
            return;
        }

        if (wager > getMoney()) {
            System.out.println("You can not wager more money than you have.");
            pause(1000);
            return;
        }

        //game info
        if (wager == 0) {
            System.out.println("You pick a coin heads or tails and everytime you get it right your wagered amount doubles. BUT if you get it wrong you lose your total amount.");
            pause(1500);
            return;
        }

        int coinSide = gen.nextInt(2) + 1;

        System.out.println("Would you like to choose heads or tails?");
        pause(700);

        String playerCoin = input.nextLine();

        //heads
        if (playerCoin.equalsIgnoreCase("heads")) {

            pause(700);

            System.out.println("The coin is flipping...");
            pause(1500);

            if (coinSide == 1) {

                int moneyGained = 2 * wager;

                System.out.println("The coin landed on heads!");
                pause(700);

                System.out.println("Good job! You correctly guessed you now have a profit totaling " + moneyGained + " dollars!");

                addMoney(moneyGained);

            } else {

                System.out.println("The coin landed on tails!");
                pause(700);

                System.out.println("Sorry you guessed incorrectly.");
                subtractMoney(wager);
            }

        }

        //tails
        else if (playerCoin.equalsIgnoreCase("tails")) {

            pause(700);

            System.out.println("The coin is flipping...");
            pause(1500);

            if (coinSide == 2) {

                int moneyGained = 2 * wager;

                System.out.println("The coin landed on tails!");
                pause(700);

                System.out.println("Good job! You correctly guessed you now have a profit totaling " + moneyGained + " dollars!");

                addMoney(moneyGained);

            } else {

                System.out.println("The coin landed on heads!");
                pause(700);

                System.out.println("Sorry you guessed incorrectly.");
                subtractMoney(wager);
            }

        } else {
            System.out.println("That is not a valid choice.");
            pause(1000);
        }
    }


    //blackjack

    public int dealerFirstCard(Random gen) {

        int casinoCard1 = drawCard(gen);

        return casinoCard1;
    }


    public int dealerSecondCard(Random gen, int casinoCard1) {

        int[] dealerAceCount = {0};
        int casinoTotal = 0;

        //dealer first card
        casinoTotal = addBlackjackCard(
                casinoTotal,
                casinoCard1,
                dealerAceCount
        );

        //dealer second card
        int casinoCard2 = drawCard(gen);

        displayCard("The dealer's second", casinoCard2);
        pause(1000);

        casinoTotal = addBlackjackCard(
                casinoTotal,
                casinoCard2,
                dealerAceCount
        );

        System.out.println("The dealer's total is " + casinoTotal);
        pause(1000);

        //dealer hit
        while (casinoTotal < 17) {

            System.out.println("The dealer draws another card...");
            pause(1000);

            int nextCard = drawCard(gen);

            displayCard("The dealer's next", nextCard);
            pause(700);

            casinoTotal = addBlackjackCard(
                    casinoTotal,
                    nextCard,
                    dealerAceCount
            );

            System.out.println("The dealer's total is " + casinoTotal);
            pause(700);
        }

        return casinoTotal;
    }


    public void blackjack(Scanner input, Random gen) {

        boolean playingSession = true;

        while (playingSession) {

            //KICKED OUT CHECK
            if (getMoney() <= 0) {

                System.out.println("You have no money left! The casino kicks you out.");
                pause(1500);

                playingSession = false;
                break;
            }

            boolean playing = true;

            while (playing) {

                int ptotal = 0;
                int[] aceCount = {0};

                System.out.println("You currently got " + getMoney() + " dollars!");
                pause(700);

                System.out.println("How much would you like to wager or type 0 to know how the game works.");

                int wager = input.nextInt();
                input.nextLine();

                //wager check
                if (wager < 0) {

                    System.out.println("You can not wager a negative amount.");
                    pause(1000);

                    continue;
                }

                if (wager > getMoney()) {

                    System.out.println("You can not wager more money than you have.");
                    pause(1000);

                    continue;
                }

                //game info
                if (wager == 0) {

                    System.out.println("In Blackjack, try to get closer to 21 than the dealer without going over.");
                    pause(700);

                    System.out.println("Aces count as 11 when possible and 1 when counting them as 11 would make you bust.");
                    pause(1200);

                    continue;
                }


                //dealer card
                System.out.println("The dealer is dealing...");
                pause(1000);

                int card1 = dealerFirstCard(gen);

                displayCard("The dealer's first", card1);
                pause(1000);


                //player first card
                int pcard1 = dealerFirstCard(gen);

                ptotal = addBlackjackCard(
                        ptotal,
                        pcard1,
                        aceCount
                );

                if (pcard1 == 1) {
                    System.out.println("Your first card is an Ace");
                } else {
                    System.out.println("Your first card is " + pcard1);
                }

                pause(700);


                //player second card
                int pcard2 = dealerFirstCard(gen);

                ptotal = addBlackjackCard(
                        ptotal,
                        pcard2,
                        aceCount
                );

                if (pcard2 == 1) {
                    System.out.println("Your second card is an Ace");
                } else {
                    System.out.println("Your second card is " + pcard2);
                }

                pause(700);

                System.out.println("Your total is " + ptotal);
                pause(1000);


                //blackjack
                if (ptotal == 21) {

                    System.out.println("BLACKJACK!");
                    pause(1500);

                    addMoney(wager);

                    playing = false;
                }

                else {

                    boolean bust2 = false;
                    boolean standing = false;

                    //player turn
                    while (!bust2 && !standing) {

                        System.out.println("Would you like to hit or stand?");
                        String choice = input.nextLine();

                        //hit
                        if (choice.equalsIgnoreCase("hit")) {

                            pause(700);

                            System.out.println("You draw another card...");
                            pause(1000);

                            int pcard3 = dealerFirstCard(gen);

                            if (pcard3 == 1) {
                                System.out.println("Your next card is an Ace");
                            } else {
                                System.out.println("Your next card is a " + pcard3);
                            }

                            pause(700);

                            ptotal = addBlackjackCard(
                                    ptotal,
                                    pcard3,
                                    aceCount
                            );

                            System.out.println("Your total is " + ptotal);
                            pause(700);

                            if (ptotal > 21) {
                                bust2 = true;
                            }
                        }

                        //stand
                        else if (choice.equalsIgnoreCase("stand")) {

                            pause(700);

                            System.out.println("You stand with " + ptotal);
                            pause(1000);

                            standing = true;
                        }

                        //invalid
                        else {

                            System.out.println("Invalid choice.");
                            pause(700);
                        }
                    }


                    //player bust
                    if (bust2) {

                        System.out.println("Ouuuu you busted.");
                        pause(1000);

                        System.out.println("Your card total is " + ptotal);
                        pause(700);

                        System.out.println("You lost " + wager + " dollars.");
                        pause(1000);

                        subtractMoney(wager);

                        playing = false;
                    }


                    //player stand
                    if (!bust2 && standing) {

                        System.out.println("Your card total is " + ptotal);
                        pause(700);

                        System.out.println("The dealer reveals their second card...");
                        pause(1500);

                        int cardTotal = dealerSecondCard(
                                gen,
                                card1
                        );

                        pause(700);

                        System.out.println("The dealer finished with " + cardTotal);
                        pause(1000);


                        //dealer bust
                        if (cardTotal > 21) {

                            System.out.println("The dealer busted! You win!");
                            pause(1200);

                            addMoney(wager);

                            playing = false;
                        }


                        //player win
                        else if (ptotal > cardTotal) {

                            System.out.println("You win!");
                            pause(1200);

                            addMoney(wager);

                            playing = false;
                        }


                        //player lose
                        else if (ptotal < cardTotal) {

                            System.out.println("You lose!");
                            pause(1200);

                            subtractMoney(wager);

                            playing = false;
                        }


                        //draw
                        else {

                            System.out.println("You drew!");
                            pause(1200);

                            playing = false;
                        }
                    }
                }
            }


            //KICKED OUT CHECK
            if (getMoney() <= 0) {

                System.out.println("You have no money left! The casino kicks you out.");
                pause(1500);

                playingSession = false;
            }

            //play again
            if (playingSession) {

                boolean asking = true;

                while (asking) {

                    System.out.println("You currently got " + getMoney() + " dollars!");
                    pause(700);

                    System.out.println("Would you like to play again? (Yes/No)");

                    String playAgain = input.nextLine();

                    //yes
                    if (playAgain.equalsIgnoreCase("yes")) {

                        pause(700);

                        asking = false;
                    }

                    //no
                    else if (playAgain.equalsIgnoreCase("no")) {

                        pause(700);

                        asking = false;
                        playingSession = false;
                    }

                    //invalid
                    else {

                        System.out.println("Invalid choice.");
                        pause(700);
                    }
                }
            }
        }
    }

    //end blackjack


    //start horse racing
    public void horseRacing(Scanner input, Random gen) {

        int horseWinner = gen.nextInt(6);
        double[] horseMoney = new double[6];

        System.out.println("Welcome to the race track!");
        pause(350);
        System.out.println("The horses betting odds today are...");
        pause(1000);

        for (int i = 0; i < 6; i++) {
            double rawMultiplier = 1 + gen.nextDouble() * 4;       // 1.0 - 5.0
            horseMoney[i] = Math.round(rawMultiplier * 100) / 100.0; // round to 2 decimals
            System.out.println("Horse " + i + " multiplier is " + horseMoney[i]);
            pause(300);
        }

        int selectedHorse = -1;
        while (selectedHorse < 0 || selectedHorse > 5) {
            System.out.println("Which number horse would you like to bet on? (0-5)");
            selectedHorse = input.nextInt();
            if (selectedHorse < 0 || selectedHorse > 5) {
                System.out.println("Invalid selection. Please choose a horse between 0 and 5.");
            }
        }

        System.out.println("How much would you like to bet?");
        int wager = input.nextInt();
        double payout = wager * horseMoney[selectedHorse];
        pause(350);
        System.out.println("You bet " + wager + " on horse " + selectedHorse + ".");
        System.out.println("Your total payout would be " + payout + " dollars.");

        pause(500);
        System.out.println("The horses are lining up at the gate...");
        pause(800);
        System.out.println("And they're off!");
        pause(600);
        System.out.println("It's a tight pack coming out of the first turn...");
        pause(700);
        System.out.println("Horse " + gen.nextInt(6) + " is pushing ahead!");
        pause(700);
        System.out.println("But horse " + gen.nextInt(6) + " is closing in fast...");
        pause(800);
        System.out.println("Coming down the final stretch...");
        pause(900);
        System.out.println("And the winner is... Horse " + horseWinner + "!");
        pause(500);

        if (selectedHorse == horseWinner) {
            addMoney((int) payout);
            System.out.println("You won " + payout + " dollars.");
            System.out.println("You have " + getMoney() + " dollars.");
        } else {
            subtractMoney(wager);
            System.out.println("You lost " + wager + " dollars.");
            System.out.println("You have " + getMoney() + " dollars.");
        }
    }

    //end horse racing
}