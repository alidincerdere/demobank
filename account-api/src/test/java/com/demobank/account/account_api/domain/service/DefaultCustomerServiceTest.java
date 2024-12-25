package com.demobank.account.account_api.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.demobank.account.account_api.domain.model.Customer;
import com.demobank.account.account_api.domain.port.CustomerDataPort;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DefaultCustomerServiceTest {

    @Mock
    private CustomerDataPort customerDataPort;

    @InjectMocks
    private DefaultCustomerService defaultCustomerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_ShouldReturnUUID_WhenCalledWithValidArguments() {
        // Arrange
        String name = "Ali";
        String surName = "Dere";
        UUID expectedUuid = UUID.randomUUID();

        when(customerDataPort.create(name, surName)).thenReturn(expectedUuid);

        // Act
        UUID result = defaultCustomerService.create(name, surName);

        // Assert
        assertEquals(expectedUuid, result);
        verify(customerDataPort, times(1)).create(name, surName);
    }

    @Test
    void retrieve_ShouldReturnCustomer_WhenCalledWithValidCustomerId() {
        // Arrange
        UUID customerId = UUID.randomUUID();
        Customer expectedCustomer = new Customer(); // Assume a no-args constructor or mock object

        when(customerDataPort.retrieveUser(customerId)).thenReturn(expectedCustomer);

        // Act
        Customer result = defaultCustomerService.retrieve(customerId);

        // Assert
        assertEquals(expectedCustomer, result);
        verify(customerDataPort, times(1)).retrieveUser(customerId);
    }
}

