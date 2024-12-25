package com.demobank.transaction.transaction_api.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.demobank.transaction.transaction_api.domain.model.Transaction;
import com.demobank.transaction.transaction_api.domain.model.TransactionResult;
import com.demobank.transaction.transaction_api.domain.model.TransactionType;
import com.demobank.transaction.transaction_api.domain.port.AccountServiceAccessPort;
import com.demobank.transaction.transaction_api.domain.port.TransactionDataPort;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DefaultTransactionServiceTest {

    @Mock
    private TransactionDataPort transactionDataPort;

    @Mock
    private AccountServiceAccessPort accountServiceAccessPort;

    @InjectMocks
    private DefaultTransactionService defaultTransactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void process_ShouldReturnSuccess_WhenDepositIsSuccessful() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        BigDecimal amount = BigDecimal.valueOf(100);
        TransactionType type = TransactionType.DEPOSIT;
        TransactionResult expectedResult = TransactionResult.SUCCESS;

        when(accountServiceAccessPort.deposit(accountId, amount)).thenReturn(expectedResult);

        // Act
        TransactionResult result = defaultTransactionService.process(accountId, amount, type);

        // Assert
        assertEquals(expectedResult, result);
        verify(accountServiceAccessPort, times(1)).deposit(accountId, amount);
        verify(accountServiceAccessPort, never()).withdraw(any(), any());
    }

    @Test
    void process_ShouldReturnSuccess_WhenWithdrawIsSuccessful() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        BigDecimal amount = BigDecimal.valueOf(50);
        TransactionType type = TransactionType.WITHDRAW;
        TransactionResult expectedResult = TransactionResult.SUCCESS;

        when(accountServiceAccessPort.withdraw(accountId, amount)).thenReturn(expectedResult);

        // Act
        TransactionResult result = defaultTransactionService.process(accountId, amount, type);

        // Assert
        assertEquals(expectedResult, result);
        verify(accountServiceAccessPort, times(1)).withdraw(accountId, amount);
        verify(accountServiceAccessPort, never()).deposit(any(), any());
    }

    @Test
    void process_ShouldReturnNotEnoughFunds_WhenWithdrawFailsDueToInsufficientFunds() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        BigDecimal amount = BigDecimal.valueOf(200);
        TransactionType type = TransactionType.WITHDRAW;
        TransactionResult expectedResult = TransactionResult.NOT_ENOUGH_FUNDS;

        when(accountServiceAccessPort.withdraw(accountId, amount)).thenReturn(expectedResult);

        // Act
        TransactionResult result = defaultTransactionService.process(accountId, amount, type);

        // Assert
        assertEquals(expectedResult, result);
        verify(accountServiceAccessPort, times(1)).withdraw(accountId, amount);
        verify(accountServiceAccessPort, never()).deposit(any(), any());
    }

    @Test
    void process_ShouldReturnAccountNotFound_WhenAccountDoesNotExist() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        BigDecimal amount = BigDecimal.valueOf(100);
        TransactionType type = TransactionType.DEPOSIT;
        TransactionResult expectedResult = TransactionResult.ACCOUNT_NOT_FOUND;

        when(accountServiceAccessPort.deposit(accountId, amount)).thenReturn(expectedResult);

        // Act
        TransactionResult result = defaultTransactionService.process(accountId, amount, type);

        // Assert
        assertEquals(expectedResult, result);
        verify(accountServiceAccessPort, times(1)).deposit(accountId, amount);
        verify(accountServiceAccessPort, never()).withdraw(any(), any());
    }

    @Test
    void saveTransaction_ShouldReturnTransactionId_WhenTransactionIsSaved() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        BigDecimal amount = BigDecimal.valueOf(150);
        TransactionType type = TransactionType.DEPOSIT;
        UUID expectedTransactionId = UUID.randomUUID();

        Transaction transaction = Transaction.builder()
                .accountId(accountId)
                .amount(amount)
                .dateTime(LocalDateTime.now())
                .type(type)
                .build();

        when(transactionDataPort.saveTransaction(any(Transaction.class))).thenReturn(expectedTransactionId);

        // Act
        UUID result = defaultTransactionService.saveTransaction(accountId, amount, type);

        // Assert
        assertEquals(expectedTransactionId, result);
        verify(transactionDataPort, times(1)).saveTransaction(any(Transaction.class));
    }

    @Test
    void getTransactionListByAccountId_ShouldReturnTransactionList_WhenAccountHasTransactions() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        List<Transaction> expectedTransactions = List.of(new Transaction(), new Transaction());

        when(transactionDataPort.retrieveAccountTransactions(accountId)).thenReturn(expectedTransactions);

        // Act
        List<Transaction> result = defaultTransactionService.getTransactionListByAccountId(accountId);

        // Assert
        assertEquals(expectedTransactions, result);
        verify(transactionDataPort, times(1)).retrieveAccountTransactions(accountId);
    }
}
