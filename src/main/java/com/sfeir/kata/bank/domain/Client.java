package com.sfeir.kata.bank.domain;

public class Client {

    private Account account;

    public Client() {
        this.account = new Account();
    }

    public Account getAccount() {
        return this.account;
    }
}
