package com.demobank.account.account_api.infra.adapter;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.model.Account;
import com.demobank.account.account_api.domain.port.AccountDataPort;
import com.demobank.account.account_api.infra.persistence.entity.AccountEntity;
import com.demobank.account.account_api.infra.persistence.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountDataAdapter implements AccountDataPort {

    private AccountRepository accountRepository;
    private ModelMapper modelMapper;

    @Override
    public Account retrieveAccount(UUID accountId) {

        AccountEntity accountEntity = accountRepository.getReferenceById(accountId);
        return modelMapper.map(accountEntity, Account.class);
    }

    @Override
    public List<Account> retrieveAccountList(UUID customerId) {

        return accountRepository.findAllByCustomerId(customerId).stream().map(x -> modelMapper.map(x, Account.class))
                .toList();
    }

    @Override
    public UUID save(Account account) {

        AccountEntity accountEntity;
        
        if(account.getAccountId() != null) {
            //existing account
            accountEntity = accountRepository.findById(account.getAccountId()).orElseThrow();
            accountEntity.setAmount(account.getAmount());
            
        } else {
            accountEntity = modelMapper.map(account, AccountEntity.class);
        }
        return accountRepository.save(accountEntity).getAccountId();
    }

}
