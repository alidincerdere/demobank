package com.demobank.account.account_api.domain.port;

import java.util.List;

import com.demobank.account.account_api.domain.model.Account;

public interface AccountDataPort {

    Account retrieveAccount(long accountId);

    List<Account> retrieveAccountList(long customerId);
    
    
}
