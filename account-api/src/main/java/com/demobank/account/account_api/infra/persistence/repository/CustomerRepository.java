package com.demobank.account.account_api.infra.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demobank.account.account_api.infra.persistence.entity.CustomerEntity;

public interface CustomerRepository  extends JpaRepository<CustomerEntity, UUID> {
    

}
