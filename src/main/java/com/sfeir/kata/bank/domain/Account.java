package com.sfeir.kata.bank.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private List<Statement> operations;

    private BigDecimal balance;

    public Account() {
        operations = new ArrayList<>(1000);
        balance = BigDecimal.ZERO;
    }

    protected void addOperation(Statement statement) {
        operations.add(statement);
    }

    public double getBalance() {
        return balance.doubleValue();
    }

    public void deposit(double amount) {
        balance = balance.add(BigDecimal.valueOf(amount));
        addOperation(new Statement(Operation.DEPOSIT, amount, balance.doubleValue()));
    }

    public void withdraw(double amount) {
        if (amount > balance.doubleValue()) {
            System.err.println("Montant supérieur à la balance du compte!");
            return;
        }
        balance = balance.subtract(BigDecimal.valueOf(amount));
        addOperation(new Statement(Operation.WITHDRAW, amount, balance.doubleValue()));
    }

    public void printHistory() {
        operations.forEach(Statement::print);
    }
}
