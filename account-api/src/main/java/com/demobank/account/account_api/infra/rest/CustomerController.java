package com.demobank.account.account_api.infra.rest;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demobank.account.account_api.domain.command.CreateCustomer;
import com.demobank.account.account_api.domain.command.handler.CommandHandler;
import com.demobank.account.account_api.domain.exception.NoSuchCustomerExistsException;
import com.demobank.account.account_api.domain.query.CustomerQuery;
import com.demobank.account.account_api.domain.query.CustomerQueryResponse;
import com.demobank.account.account_api.domain.query.handler.QueryHandler;
import com.demobank.account.account_api.infra.dto.request.CustomerCreateRequestDto;
import com.demobank.account.account_api.infra.dto.response.CustomerDto;
import com.demobank.account.account_api.infra.rest.error.ErrorResponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CustomerController implements CustomerOperations {

    private CommandHandler<CreateCustomer, UUID> createCustomerCommandHandler;
    private QueryHandler<CustomerQuery, CustomerQueryResponse> customerQueryHandler;
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<CustomerDto> create(CustomerCreateRequestDto customerCreateRequestDto) {

        UUID customerId = createCustomerCommandHandler.handle(modelMapper.map(customerCreateRequestDto, CreateCustomer.class));

        return ResponseEntity.ok().body(CustomerDto.builder().id(customerId).build());

    }

    @Override
    public ResponseEntity<CustomerDto> retrieve(UUID id) {

        return ResponseEntity.ok().body(modelMapper
                .map(customerQueryHandler.handle(CustomerQuery.builder().id(id).build()), CustomerDto.class));
    }

}
