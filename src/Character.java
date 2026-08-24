public class Character {

    private int money;


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

}
