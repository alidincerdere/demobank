package com.demobank.account.account_api.infra.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerCreateRequestDto {

    private String name;
    private String surName;
    
}
