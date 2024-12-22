package com.demobank.account.account_api.domain.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateCustomer implements Command {

    private String name;
    private String surName;

}
