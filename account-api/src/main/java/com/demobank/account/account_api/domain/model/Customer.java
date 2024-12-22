package com.demobank.account.account_api.domain.model;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    
    private UUID customerId;
    private String name;
    private String surName;
}
