import java.io.*;
import java.util.Scanner;

public class SaveManager {

    public void save(Character player) {
        try (PrintWriter writer = new PrintWriter("save.txt")) {
            writer.println(player.getName());
            writer.println(player.getMoney());
            writer.println(player.getGamesWon());
            writer.println(player.getGamesLost());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Character load() {
        try (Scanner fileReader = new Scanner(new File("save.txt"))) {
            String name = fileReader.nextLine();
            int money = Integer.parseInt(fileReader.nextLine());
            int won = Integer.parseInt(fileReader.nextLine());
            int lost = Integer.parseInt(fileReader.nextLine());
            return new Character(name, money, won, lost);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
