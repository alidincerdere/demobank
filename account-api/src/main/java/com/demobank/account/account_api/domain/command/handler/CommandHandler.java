package com.demobank.account.account_api.domain.command.handler;

import com.demobank.account.account_api.domain.command.Command;

public interface CommandHandler <T extends Command, R>{
    
    R handle(T command);
    
}
