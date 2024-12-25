package com.demobank.transaction.transaction_api.infra.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demobank.transaction.transaction_api.infra.rest.dto.request.TransactionRequestDto;
import com.demobank.transaction.transaction_api.infra.rest.dto.response.TransactionQueryResponseDto;
import com.demobank.transaction.transaction_api.infra.rest.dto.response.TransactionResponseDto;

@RequestMapping("/transaction")
public interface TransactionOperations {
    
    @GetMapping("/home")
    public ResponseEntity<String> home();

    @PostMapping("/process")
    public ResponseEntity<TransactionResponseDto> processTransaction(@RequestBody TransactionRequestDto requestDto);

    @GetMapping    
    public ResponseEntity<List<TransactionQueryResponseDto>> retrieveTransactionForAccountId(@RequestParam UUID accountId);
}
    
    
