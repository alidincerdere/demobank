package com.demobank.account.account_api.domain.query.handler;

import com.demobank.account.account_api.domain.query.CustomerQueryResponse;
import com.demobank.account.account_api.domain.service.AccountService;
import com.demobank.account.account_api.domain.service.CustomerService;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.model.Customer;
import com.demobank.account.account_api.domain.model.Transaction;
import com.demobank.account.account_api.domain.port.TransactionServicePort;
import com.demobank.account.account_api.domain.query.AccountQueryResponse;
import com.demobank.account.account_api.domain.query.CustomerQuery;

@Component
@AllArgsConstructor
public class CustomerQueryHandler implements QueryHandler<CustomerQuery, CustomerQueryResponse> {

    private CustomerService customerService;
    private AccountService accountService;
    private TransactionServicePort transactionServicePort;
    private ModelMapper modelMapper;

    @Override
    public CustomerQueryResponse handle(CustomerQuery query) {

        Customer customer = customerService.retrieve(query.getId());
        List<AccountQueryResponse> accountList = accountService.retrieveAccountList(customer.getCustomerId()).stream().map(x-> modelMapper.map(x, AccountQueryResponse.class)).toList();
        for(AccountQueryResponse account: accountList) {
            List<Transaction> transactions = transactionServicePort.retrieveTransactionsByAccount(account.getAccountId());
            account.setTransactionList(transactions);
            
        }

        BigDecimal balance = accountList.stream().map(x -> x.getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);

        CustomerQueryResponse customerQueryResponse = CustomerQueryResponse.builder().name(customer.getName())
                .surName(customer.getSurName())
                .customerId(customer.getCustomerId())
                .accountList(accountList)
                .balance(balance).build();


        return customerQueryResponse;

    }

}
