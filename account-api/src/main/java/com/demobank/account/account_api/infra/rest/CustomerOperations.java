package com.demobank.account.account_api.infra.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demobank.account.account_api.infra.dto.request.CustomerCreateRequestDto;
import com.demobank.account.account_api.infra.dto.response.CustomerDto;

import jakarta.websocket.server.PathParam;

@RequestMapping("/customer")
public interface CustomerOperations {

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody CustomerCreateRequestDto customerCreateRequestDto);

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> retrieve(@PathVariable Long id);
    
}
