package com.demobank.account.account_api.infra.rest;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.demobank.account.account_api.domain.command.CreateCustomer;
import com.demobank.account.account_api.domain.command.handler.CommandHandler;
import com.demobank.account.account_api.domain.query.CustomerQuery;
import com.demobank.account.account_api.domain.query.CustomerQueryResponse;
import com.demobank.account.account_api.domain.query.handler.QueryHandler;
import com.demobank.account.account_api.infra.dto.request.CustomerCreateRequestDto;
import com.demobank.account.account_api.infra.dto.response.CustomerDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CustomerController implements CustomerOperations {

    private CommandHandler<CreateCustomer, Long> createCustomerCommandHandler;
    private QueryHandler<CustomerQuery, CustomerQueryResponse> customerQueryHandler;
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Long> create(CustomerCreateRequestDto customerCreateRequestDto) {

        return ResponseEntity.ok().body(
                createCustomerCommandHandler.handle(modelMapper.map(customerCreateRequestDto, CreateCustomer.class)));

    }

    @Override
    public ResponseEntity<CustomerDto> retrieve(Long id) {

        return ResponseEntity.ok().body(modelMapper
                .map(customerQueryHandler.handle(CustomerQuery.builder().id(id).build()), CustomerDto.class));
    }

}