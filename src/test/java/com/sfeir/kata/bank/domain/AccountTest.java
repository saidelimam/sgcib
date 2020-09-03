package com.sfeir.kata.bank.domain;

import com.sfeir.kata.bank.SpyObject;
import com.sfeir.kata.bank.TestBeansFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void account_should_deposit_once() {
        // Given
        var addOperationSpy = new SpyObject();
        var account = TestBeansFactory.accountBean(addOperationSpy);
        // When
        account.deposit(100);
        // Then
        assertEquals(100, account.getBalance());
        assertTrue(addOperationSpy.isCalled());
        assertEquals(1, addOperationSpy.timesCalled());
    }

    @Test
    void account_should_deposit_multiple_times() {
        // Given
        var addOperationSpy = new SpyObject();
        var account = TestBeansFactory.accountBean(addOperationSpy);
        // When
        account.deposit(50);
        account.deposit(20);
        account.deposit(30);
        // Then
        assertEquals(100, account.getBalance());
        assertTrue(addOperationSpy.isCalled());
        assertEquals(3, addOperationSpy.timesCalled());
    }

    @Test
    void account_should_withdraw_once() {
        // Given
        var addOperationSpy = new SpyObject();
        var account = TestBeansFactory.accountBean(addOperationSpy);
        account.deposit(100);
        // When
        account.withdraw(50);
        // Then
        assertEquals(50, account.getBalance());
        assertTrue(addOperationSpy.isCalled());
        assertEquals(2, addOperationSpy.timesCalled());
    }

    @Test
    void account_should_withdraw_multiple_times() {
        // Given
        var addOperationSpy = new SpyObject();
        var account = TestBeansFactory.accountBean(addOperationSpy);
        account.deposit(100);
        // When
        account.withdraw(20);
        account.withdraw(30);
        // Then
        assertEquals(50, account.getBalance());
        assertTrue(addOperationSpy.isCalled());
        assertEquals(3, addOperationSpy.timesCalled());
    }

    @Test
    void account_should_not_withdraw_more_than_balance() {
        // Given
        var addOperationSpy = new SpyObject();
        var account = TestBeansFactory.accountBean(addOperationSpy);
        account.deposit(100);
        // When
        account.withdraw(200);
        // Then
        assertEquals(100, account.getBalance());
        assertEquals(1, addOperationSpy.timesCalled());
    }
}
