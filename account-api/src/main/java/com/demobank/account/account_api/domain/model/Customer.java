package com.demobank.account.account_api.domain.model;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    
    private UUID customerId;
    private String name;
    private String surName;
}
