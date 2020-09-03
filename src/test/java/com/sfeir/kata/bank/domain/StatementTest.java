package com.sfeir.kata.bank.domain;

import com.sfeir.kata.bank.TestBeansFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatementTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void statement_should_print_deposit_operation() {
        // Given
        var statement = new Statement(TestBeansFactory.dateProviderBean(), Operation.DEPOSIT, 10.3d, 200.3d);
        // When
        statement.print();
        // Then
        assertEquals("{date=2020-08-01T00:00, operation=DEPOSIT, amount=10.3, balance=200.3}", outContent.toString().trim());
    }

    @Test
    void statement_should_print_withdraw_operation() {
        // Given
        var statement = new Statement(TestBeansFactory.dateProviderBean(), Operation.WITHDRAW, 10.3d, 200.3d);
        // When
        statement.print();
        // Then
        assertEquals("{date=2020-08-01T00:00, operation=WITHDRAW, amount=10.3, balance=200.3}", outContent.toString().trim());
    }
}
