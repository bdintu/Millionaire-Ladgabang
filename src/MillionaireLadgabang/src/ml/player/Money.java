package ml.player;

public class Money {

    private final double initial_money = 3e6;
    private final double money_per_round = 2e5;

    private double amount;

    public Money() {
        amount = 0;
    }

    public void setInitialMoney() {
        this.amount = initial_money;
    }

    public void addMoneyPerRound() {
        this.amount += money_per_round;
    }

    public void addMoney(double amount) {
            this.amount += amount;
    }

    public boolean checkMoney(double amount) {
        if (this.amount > amount) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMoney() {
        return amount > 0;
    }

    public double getMoney() {
        return amount;
    }
}
