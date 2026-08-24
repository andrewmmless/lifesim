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

        System.out.println("Would you like to attempt to rob the gas station?");
        pause(1000);
        System.out.println("Yes or no?");

        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            int gasPath1 = gen.nextInt(2) + 1;

            System.out.println("You successfully grab the money!");
            pause(2000);

            System.out.println("Oh shoot! There is a worker!!!");
            System.out.println("Would you like to choose the left or right path");

            String choiceLR1 = input.nextLine();

            if (choiceLR1.equalsIgnoreCase("left")) {
                int playerPath = gen.nextInt(2) + 1;

                if (gasPath1 == playerPath) {
                    System.out.println("You successfully made it out!");
                    addMoney(moneyGained);
                } else {
                    System.out.println("You have not successfully made it out.");
                    subtractMoney(moneyLost);
                }

            } else if (choiceLR1.equalsIgnoreCase("right")) {
                int playerPath = gen.nextInt(2) + 1;

                if (gasPath1 == playerPath) {
                    System.out.println("You successfully made it out!");
                    addMoney(moneyGained);
                } else {
                    System.out.println("You have not successfully made it out.");
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
            System.out.println("You found a bank note saying the vault has  " + moneyGained + " dollars!");
        }

        System.out.println("Would you like to attempt to rob the bank?");
        pause(1000);
        System.out.println("Yes or no?");

        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("You successfully break into the vault!");
            pause(2000);

            System.out.println("You spot night patrol around the corner!!!");
            System.out.println("Would you like to sprint left or right?");

            int gasPath1 = gen.nextInt(2) + 1;
            int gasPath2 = gen.nextInt(2) + 1;
            int playerPath1 = gen.nextInt(2) + 1;
            int playerPath2 = gen.nextInt(2) + 1;

            String choiceLR1 = input.nextLine();

            if (choiceLR1.equalsIgnoreCase("left")) {

                if (gasPath1 == playerPath1) {
                    System.out.println("You have made it through the first path... One more to go!");
                    pause(500);

                    System.out.println("Would you like to sprint left or right?");
                    String choiceLR2 = input.nextLine();

                    if (choiceLR2.equalsIgnoreCase("left")
                            || choiceLR2.equalsIgnoreCase("right")) {

                        if (playerPath2 == gasPath2) {
                            System.out.println("You successfully made it out!");
                            addMoney(moneyGained);
                        } else {
                            System.out.println("You have not successfully made it out.");
                            subtractMoney(moneyLost);
                        }
                    }

                } else {
                    System.out.println("You have not successfully made it out.");
                    subtractMoney(moneyLost);
                }

            } else if (choiceLR1.equalsIgnoreCase("right")) {

                if (gasPath1 == playerPath1) {
                    System.out.println("You have made it through the first path... One more to go!");
                    pause(500);

                    System.out.println("Would you like to sprint left or right?");
                    String choiceLR2 = input.nextLine();

                    if (choiceLR2.equalsIgnoreCase("left")
                            || choiceLR2.equalsIgnoreCase("right")) {

                        if (playerPath2 == gasPath2) {
                            System.out.println("You successfully made it out!");
                            addMoney(moneyGained);
                        } else {
                            System.out.println("You have not successfully made it out.");
                            subtractMoney(moneyLost);
                        }
                    }

                } else {
                    System.out.println("You have not successfully made it out.");
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
            return;
        }

        System.out.println("You currently got " + getMoney() + " dollars!");
        System.out.println("How much would you like to wager or type 0 to know how the game works.");

        int wager = input.nextInt();
        String apple = input.nextLine();

        if (wager < 0) {
            System.out.println("You can not wager a negative amount.");
            return;
        }

        if (wager > getMoney()) {
            System.out.println("You can not wager more money than you have.");
            return;
        }

        if (wager == 0) {
            System.out.println("You pick a coin heads or tails and everytime you get it right your wagered amount doubles. BUT if you get it wrong you lose your total amount.");
            return;
        }

        int coinSide = gen.nextInt(2) + 1;

        System.out.println("Would you like to choose heads or tails?");
        String playerCoin = input.nextLine();

        if (playerCoin.equalsIgnoreCase("heads")) {

            if (coinSide == 1) {
                int moneyGained = 2 * wager;

                System.out.println("Good job! You correctly guessed you now have a profit totaling " + moneyGained + " dollars!");

                addMoney(moneyGained);

            } else {
                System.out.println("Sorry you guessed incorrectly.");
                subtractMoney(wager);
            }

        } else if (playerCoin.equalsIgnoreCase("tails")) {

            if (coinSide == 2) {
                int moneyGained = 2 * wager;

                System.out.println("Good job! You correctly guessed you now have a profit totaling " + moneyGained + " dollars!");

                addMoney(moneyGained);

            } else {
                System.out.println("Sorry you guessed incorrectly.");
                subtractMoney(wager);
            }

        } else {
            System.out.println("That is not a valid choice.");
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

        casinoTotal = addBlackjackCard(
                casinoTotal,
                casinoCard2,
                dealerAceCount
        );

        System.out.println("The dealer's total is " + casinoTotal);

        //dealer hit
        while (casinoTotal < 17) {

            int nextCard = drawCard(gen);

            displayCard("The dealer's next", nextCard);

            casinoTotal = addBlackjackCard(
                    casinoTotal,
                    nextCard,
                    dealerAceCount
            );

            System.out.println("The dealer's total is " + casinoTotal);
        }

        return casinoTotal;
    }

    public void blackjack(Scanner input, Random gen) {

        boolean playingSession = true;

        while (playingSession) {

            //KICKED OUT CHECK
            if (getMoney() <= 0) {
                System.out.println("You have no money left! The casino kicks you out.");
                playingSession = false;
                break;
            }

            boolean playing = true;

            while (playing) {

                int ptotal = 0;
                int[] aceCount = {0};

                System.out.println("You currently got " + getMoney() + " dollars!");
                System.out.println("How much would you like to wager or type 0 to know how the game works.");

                int wager = input.nextInt();
                input.nextLine();

                //wager check
                if (wager < 0) {
                    System.out.println("You can not wager a negative amount.");
                    continue;
                }

                if (wager > getMoney()) {
                    System.out.println("You can not wager more money than you have.");
                    continue;
                }

                if (wager == 0) {
                    System.out.println("In Blackjack, try to get closer to 21 than the dealer without going over.");
                    System.out.println("Aces count as 11 when possible and 1 when counting them as 11 would make you bust.");
                    continue;
                }

                //dealer card
                int card1 = dealerFirstCard(gen);
                displayCard("The dealer's first", card1);

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

                System.out.println("Your total is " + ptotal);

                //blackjack
                if (ptotal == 21) {
                    System.out.println("BLACKJACK!");
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

                            int pcard3 = dealerFirstCard(gen);

                            if (pcard3 == 1) {
                                System.out.println("Your next card is an Ace");
                            } else {
                                System.out.println("Your next card is a " + pcard3);
                            }

                            ptotal = addBlackjackCard(
                                    ptotal,
                                    pcard3,
                                    aceCount
                            );

                            System.out.println("Your total is " + ptotal);

                            if (ptotal > 21) {
                                bust2 = true;
                            }
                        }

                        //stand
                        else if (choice.equalsIgnoreCase("stand")) {
                            standing = true;
                        }

                        //invalid
                        else {
                            System.out.println("Invalid choice.");
                        }
                    }

                    //player bust
                    if (bust2) {
                        System.out.println("Ouuuu you busted.");
                        System.out.println("Your card total is " + ptotal);
                        System.out.println("You lost " + wager + " dollars.");

                        subtractMoney(wager);
                        playing = false;
                    }

                    //player stand
                    if (!bust2 && standing) {

                        System.out.println("Your card total is " + ptotal);
                        System.out.println("The dealer reveals their second card...");

                        int cardTotal = dealerSecondCard(
                                gen,
                                card1
                        );

                        System.out.println("The dealer finished with " + cardTotal);

                        //dealer bust
                        if (cardTotal > 21) {
                            System.out.println("The dealer busted! You win!");
                            addMoney(wager);
                            playing = false;
                        }

                        //player win
                        else if (ptotal > cardTotal) {
                            System.out.println("You win!");
                            addMoney(wager);
                            playing = false;
                        }

                        //player lose
                        else if (ptotal < cardTotal) {
                            System.out.println("You lose!");
                            subtractMoney(wager);
                            playing = false;
                        }

                        //draw
                        else {
                            System.out.println("You drew!");
                            playing = false;
                        }
                    }
                }

                //KICKED OUT CHECK
                if (getMoney() <= 0) {
                    System.out.println("You have no money left! The casino kicks you out.");

                    playingSession = false;
                    playing = false;
                }
            }

            //play again
            if (playingSession) {

                boolean asking = true;

                while (asking) {

                    System.out.println("You currently got " + getMoney() + " dollars!");
                    System.out.println("Would you like to play again? (Yes/No)");

                    String playAgain = input.nextLine();

                    if (playAgain.equalsIgnoreCase("yes")) {
                        asking = false;

                    } else if (playAgain.equalsIgnoreCase("no")) {
                        asking = false;
                        playingSession = false;

                    } else {
                        System.out.println("Invalid choice.");
                    }
                }
            }
        }
    }
}

