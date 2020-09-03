package com.sfeir.kata.bank;

public final class SpyObject {

    private int called;

    public void call() {
        this.called++;
    }

    public boolean isCalled() {
        return this.called > 0;
    }

    public int timesCalled() {
        return this.called;
    }

}
