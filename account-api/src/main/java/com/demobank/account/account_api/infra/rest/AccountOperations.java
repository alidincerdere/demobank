package com.demobank.account.account_api.infra.rest;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demobank.account.account_api.infra.dto.request.AccountCreateRequestDto;
import com.demobank.account.account_api.infra.dto.request.AccountUpdateRequestDto;
import com.demobank.account.account_api.infra.dto.response.AccountCreateResponseDto;
import com.demobank.account.account_api.infra.dto.response.AccountUpdateResultDto;


@RequestMapping("/account")
public interface AccountOperations {
    
    @GetMapping("/home")
    public String home();

    @PostMapping
    public ResponseEntity<AccountCreateResponseDto> create(@RequestBody AccountCreateRequestDto request);

    @PutMapping("/deposit")
    public ResponseEntity<AccountUpdateResultDto> deposit(@RequestBody AccountUpdateRequestDto request);

    @PutMapping("/withdraw")
    public ResponseEntity<AccountUpdateResultDto> withdraw(@RequestBody AccountUpdateRequestDto request);

}
