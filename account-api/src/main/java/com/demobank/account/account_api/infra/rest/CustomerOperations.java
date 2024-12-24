package com.demobank.account.account_api.infra.rest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.demobank.account.account_api.infra.dto.request.CustomerCreateRequestDto;
import com.demobank.account.account_api.infra.dto.response.CustomerDto;

@RequestMapping("/customer")
public interface CustomerOperations {

    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody CustomerCreateRequestDto customerCreateRequestDto);

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> retrieve(@PathVariable UUID id);
    
}
