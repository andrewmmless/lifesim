import java.util.*;
public class main {


    public static void main(String[] args) {
    }

//PAUSE

    void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//bank rob

    public static void robBank(Scanner input, Random gen, int money, int moneyGained) {
        //Rolling Player Success
        boolean failed = false;
        int playerCheck = gen.nextInt(100) + 1;
        moneyGained = gen.nextInt(5000, 50000) + 1;

        System.out.println("You have Successfully made it inside the bank!");
        pause(1000);

        //moneyCheck
        if (playerCheck <= 40) {
            System.out.println("You secretly checked the computer and saw you could rob " + moneyGained + " dollars!");
        } else if (playerCheck >= 60) {
            System.out.println("You failed to check the computer.");
        }

        System.out.println("Would you like to attempt to rob the bank?");
        pause(5000);
        System.out.println("Yes or no?");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            int bankPath1 = gen.nextInt(2) + 1;
            int bankPath2 = gen.nextInt(2) + 1;
            System.out.println("You successfully grab the money!");
            pause(2000);
            System.out.println("Oh shoot! There is a worker!!!");
            System.out.println("Would you like to choose the left or right path");
            String choiceLR1 = input.nextLine();
            if (choiceLR1.equalsIgnoreCase("left")) {
                int playerPath = gen.nextInt(2) + 1;
                if (bankPath1 == playerPath) {
                    System.out.println("You successfully made it through the first route!");
                }
            }
        }
    }
}


