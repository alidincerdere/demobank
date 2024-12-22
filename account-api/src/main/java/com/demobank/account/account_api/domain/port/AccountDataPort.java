package com.demobank.account.account_api.domain.port;

import java.util.List;
import java.util.UUID;

import com.demobank.account.account_api.domain.model.Account;

public interface AccountDataPort {

    Account retrieveAccount(UUID accountId);

    List<Account> retrieveAccountList(UUID customerId);
    
    
}
