package com.sfeir.kata.bank;

import com.sfeir.kata.bank.domain.Client;

public class Main {

    public static void main(String[] args) {
        var client = new Client();
        var account = client.getAccount();

        // US 1
        account.deposit(100);

        // US 2
        account.withdraw(20);

        // US 3
        account.printHistory();
    }
}
