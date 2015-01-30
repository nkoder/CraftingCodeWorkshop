package pl.nkoder.craftingcodeworkshop.exercise2.calculators;

public class TotalAmountCalculator {

    private int totalAmount = 0;

    public void add(int amount) {
        totalAmount += amount;
    }

    public int totalAmount() {
        return totalAmount;
    }
}
