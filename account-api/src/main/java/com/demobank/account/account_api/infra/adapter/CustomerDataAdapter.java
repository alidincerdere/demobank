package com.demobank.account.account_api.infra.adapter;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.demobank.account.account_api.domain.model.Customer;
import com.demobank.account.account_api.domain.port.CustomerDataPort;
import com.demobank.account.account_api.infra.persistence.entity.CustomerEntity;
import com.demobank.account.account_api.infra.persistence.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomerDataAdapter implements CustomerDataPort{

    private CustomerRepository repository;
    private ModelMapper modelMapper;

    @Override
    public Customer retrieveUser(long customerId) {

        CustomerEntity customerEntity = repository.getReferenceById(customerId);

        return modelMapper.map(customerEntity, Customer.class);
    }

    @Override
    public List<Customer> retrieveUserList() {

        return repository.findAll().stream().map(x->modelMapper.map(x, Customer.class)).toList();
        
    }

    @Override
    public long create(String name, String surName) {

        return repository.save(CustomerEntity.builder().name(name).surName(surName).build()).getId();
    }
    
}
