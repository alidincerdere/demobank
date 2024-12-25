package com.demobank.account.account_api.domain.query.handler;

import com.demobank.account.account_api.domain.query.CustomerQueryResponse;
import com.demobank.account.account_api.domain.service.AccountService;
import com.demobank.account.account_api.domain.service.CustomerService;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.model.Account;
import com.demobank.account.account_api.domain.model.Customer;
import com.demobank.account.account_api.domain.port.TransactionServicePort;
import com.demobank.account.account_api.domain.query.CustomerQuery;

@Component
@AllArgsConstructor
public class CustomerQueryHandler implements QueryHandler<CustomerQuery, CustomerQueryResponse> {

    private CustomerService customerService;
    private AccountService accountService;
    private TransactionServicePort transactionServicePort;

    @Override
    public CustomerQueryResponse handle(CustomerQuery query) {

        Customer customer = customerService.retrieve(query.getId());
        List<Account> accountList = accountService.retrieveAccountList(customer.getCustomerId());

        BigDecimal balance = accountList.stream().map(x -> x.getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);

        return CustomerQueryResponse.builder().name(customer.getName())
                .surName(customer.getSurName())
                .customerId(customer.getCustomerId())
                .accountList(accountList)
                .balance(balance).build();

    }

}
