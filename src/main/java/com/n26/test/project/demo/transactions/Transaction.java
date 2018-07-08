package com.n26.test.project.demo.transactions;

public class Transaction {
    final long time;
    final double amount;

    public Transaction(long time, double amount) {
        this.time = time;
        this.amount = amount;
    }

    public long getTime() {
        return time;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "time=" + time +
                ", amount=" + amount +
                '}';
    }
}
