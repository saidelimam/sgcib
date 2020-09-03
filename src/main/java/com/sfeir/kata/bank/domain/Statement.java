package com.sfeir.kata.bank.domain;

import java.time.LocalDateTime;

public class Statement {

    private LocalDateTime date;

    private Operation operation;

    private double amount;

    private double balance;

    public Statement(DateProvider dp, Operation operation, double amount, double balance) {
        this.date = dp.now();
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public Statement(Operation operation, double amount, double balance) {
        this.date = new DateProvider().now();
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return '{' +
                "date=" + date +
                ", operation=" + operation +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
