package com.demobank.account.account_api.infra.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.exception.NoSuchCustomerExistsException;
import com.demobank.account.account_api.domain.model.Customer;
import com.demobank.account.account_api.domain.port.CustomerDataPort;
import com.demobank.account.account_api.infra.persistence.entity.CustomerEntity;
import com.demobank.account.account_api.infra.persistence.repository.CustomerRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class CustomerDataAdapter implements CustomerDataPort{

    private CustomerRepository repository;
    private ModelMapper modelMapper;

    @Override
    public Customer retrieveUser(UUID customerId) {

        Optional<CustomerEntity> optionalCustomerEntity = repository.findById(customerId);
        if(optionalCustomerEntity.isEmpty()) {
            log.error("Customer not found {}",customerId);
            throw new NoSuchCustomerExistsException(customerId.toString());
        }
        return modelMapper.map(optionalCustomerEntity.get(), Customer.class);
    }

    @Override
    public List<Customer> retrieveUserList() {

        return repository.findAll().stream().map(x->modelMapper.map(x, Customer.class)).toList();
        
    }

    @Override
    public UUID create(String name, String surName) {

        return repository.save(CustomerEntity.builder().name(name).surName(surName).build()).getId();
    }
    
}
