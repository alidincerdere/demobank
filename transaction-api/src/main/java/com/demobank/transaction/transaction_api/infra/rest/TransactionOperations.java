package com.demobank.transaction.transaction_api.infra.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demobank.transaction.transaction_api.infra.rest.dto.request.TransactionRequestDto;
import com.demobank.transaction.transaction_api.infra.rest.dto.response.TransactionResponseDto;

@RequestMapping("/transaction")
public interface TransactionOperations {
    
    @GetMapping("/home")
    public ResponseEntity<String> home();

    @PostMapping("/process")
    public ResponseEntity<TransactionResponseDto> processTransaction(@RequestBody TransactionRequestDto requestDto);
}
    
    
