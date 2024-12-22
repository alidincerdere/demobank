package com.demobank.account.account_api.infra.adapter;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.model.Account;
import com.demobank.account.account_api.domain.port.AccountDataPort;
import com.demobank.account.account_api.infra.persistence.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountDataAdapter implements AccountDataPort {

    private AccountRepository accountRepository;
    private ModelMapper modelMapper;

    @Override
    public Account retrieveAccount(long accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retrieveAccount'");
    }

    @Override
    public List<Account> retrieveAccountList(long customerId) {

        return accountRepository.findAllByCustomerId(customerId).stream().map(x -> modelMapper.map(x, Account.class))
                .toList();
    }

}
