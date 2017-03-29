package ml;

public class Money {

    public static int start_money = (int) 3e6;
    public static int money_per_round = (int) 2e5;

    int money;

    public Money() {
        money = 0;
    }

    public void startMoney() {
        money = start_money;
    }

    public void addMoneyPerRound() {
        money += money_per_round;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void delMoney(int amount) {
        if (isMoneyEmpty()) {
            money -= amount;
        }
    }

    public boolean isMoneyEmpty() {
        return money > 0;
    }

    public int getMoney() {
        return money;
    }
}