public class Character {
    private String name;
    private int money;
    private int gamesWon;
    private int gamesLost;

    public Character(String name, int money) {
        this.name = name;
        this.money = money;
        this.gamesWon = 0;
        this.gamesLost = 0;
    }

    // used by SaveManager when loading a character that already has win/loss history
    public Character(String name, int money, int gamesWon, int gamesLost) {
        this.name = name;
        this.money = money;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
    }

    public String getName() { return name; }
    public int getMoney() { return money; }
    public int getGamesWon() { return gamesWon; }
    public int getGamesLost() { return gamesLost; }

    public void addMoney(int amount) { money += amount; }
    public void subtractMoney(int amount) { money -= amount; }
    public void cheatMoney(int amount) { money += amount; }
    public void recordWin() { gamesWon++; }
    public void recordLoss() { gamesLost++; }
}
