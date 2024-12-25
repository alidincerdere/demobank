package com.demobank.account.account_api.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.demobank.account.account_api.domain.model.Account;
import com.demobank.account.account_api.domain.model.AccountUpdateResult;
import com.demobank.account.account_api.domain.model.Customer;
import com.demobank.account.account_api.domain.port.AccountDataPort;
import com.demobank.account.account_api.domain.port.CustomerDataPort;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DefaultAccountServiceTest {

    @Mock
    private AccountDataPort accountDataPort;

    @Mock
    private CustomerDataPort customerDataPort;

    @InjectMocks
    private DefaultAccountService defaultAccountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_ShouldReturnUUID_WhenCustomerExists() {
        // Arrange
        UUID customerId = UUID.randomUUID();
        Customer customer = new Customer();
        Account account = Account.builder().amount(BigDecimal.ZERO).customerId(customerId).build();
        UUID expectedAccountId = UUID.randomUUID();

        when(customerDataPort.retrieveUser(customerId)).thenReturn(customer);
        when(accountDataPort.save(account)).thenReturn(expectedAccountId);

        // Act
        UUID result = defaultAccountService.create(customerId);

        // Assert
        assertEquals(expectedAccountId, result);
        verify(customerDataPort, times(1)).retrieveUser(customerId);
        verify(accountDataPort, times(1)).save(account);
    }

    @Test
    void deposit_ShouldReturnSuccess_WhenAccountExists() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        BigDecimal depositAmount = BigDecimal.valueOf(100);
        Account account = new Account();
        account.setAmount(BigDecimal.valueOf(200));

        when(accountDataPort.retrieveAccount(accountId)).thenReturn(account);

        // Act
        AccountUpdateResult result = defaultAccountService.deposit(accountId, depositAmount);

        // Assert
        assertEquals(AccountUpdateResult.SUCCESS, result);
        assertEquals(BigDecimal.valueOf(300), account.getAmount());
        verify(accountDataPort, times(1)).save(account);
    }

    @Test
    void deposit_ShouldReturnAccountNotFound_WhenAccountDoesNotExist() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        BigDecimal depositAmount = BigDecimal.valueOf(100);

        when(accountDataPort.retrieveAccount(accountId)).thenReturn(null);

        // Act
        AccountUpdateResult result = defaultAccountService.deposit(accountId, depositAmount);

        // Assert
        assertEquals(AccountUpdateResult.ACCOUNT_NOT_FOUND, result);
        verify(accountDataPort, never()).save(any(Account.class));
    }

    @Test
    void withdraw_ShouldReturnSuccess_WhenSufficientFundsExist() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        BigDecimal withdrawalAmount = BigDecimal.valueOf(100);
        Account account = new Account();
        account.setAmount(BigDecimal.valueOf(200));

        when(accountDataPort.retrieveAccount(accountId)).thenReturn(account);

        // Act
        AccountUpdateResult result = defaultAccountService.withdraw(accountId, withdrawalAmount);

        // Assert
        assertEquals(AccountUpdateResult.SUCCESS, result);
        assertEquals(BigDecimal.valueOf(100), account.getAmount());
        verify(accountDataPort, times(1)).save(account);
    }

    @Test
    void withdraw_ShouldReturnNotEnoughFunds_WhenInsufficientFundsExist() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        BigDecimal withdrawalAmount = BigDecimal.valueOf(300);
        Account account = new Account();
        account.setAmount(BigDecimal.valueOf(200));

        when(accountDataPort.retrieveAccount(accountId)).thenReturn(account);

        // Act
        AccountUpdateResult result = defaultAccountService.withdraw(accountId, withdrawalAmount);

        // Assert
        assertEquals(AccountUpdateResult.NOT_ENOUGH_FUNDS, result);
        assertEquals(BigDecimal.valueOf(200), account.getAmount());
        verify(accountDataPort, never()).save(account);
    }

    @Test
    void withdraw_ShouldReturnAccountNotFound_WhenAccountDoesNotExist() {
        // Arrange
        UUID accountId = UUID.randomUUID();
        BigDecimal withdrawalAmount = BigDecimal.valueOf(100);

        when(accountDataPort.retrieveAccount(accountId)).thenReturn(null);

        // Act
        AccountUpdateResult result = defaultAccountService.withdraw(accountId, withdrawalAmount);

        // Assert
        assertEquals(AccountUpdateResult.ACCOUNT_NOT_FOUND, result);
        verify(accountDataPort, never()).save(any(Account.class));
    }

    @Test
    void retrieveAccountList_ShouldReturnAccounts_WhenCustomerExists() {
        // Arrange
        UUID customerId = UUID.randomUUID();
        List<Account> expectedAccounts = List.of(new Account(), new Account());

        when(accountDataPort.retrieveAccountList(customerId)).thenReturn(expectedAccounts);

        // Act
        List<Account> result = defaultAccountService.retrieveAccountList(customerId);

        // Assert
        assertEquals(expectedAccounts, result);
        verify(accountDataPort, times(1)).retrieveAccountList(customerId);
    }
}

