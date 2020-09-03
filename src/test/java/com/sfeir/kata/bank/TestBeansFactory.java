package com.sfeir.kata.bank;

import com.sfeir.kata.bank.domain.Account;
import com.sfeir.kata.bank.domain.DateProvider;
import com.sfeir.kata.bank.domain.Statement;

import java.time.LocalDateTime;
import java.time.Month;

public final class TestBeansFactory {

    private TestBeansFactory() {
    }

    public static DateProvider dateProviderBean() {
        return new DateProvider() {
            @Override
            public LocalDateTime now() {
                return LocalDateTime.of(2020, Month.AUGUST, 1, 0, 0);
            }
        };
    }

    public static Account accountBean(final SpyObject operationSpy) {
        return new Account() {
            @Override
            protected void addOperation(Statement statement) {
                operationSpy.call();
            }
        };
    }
}
