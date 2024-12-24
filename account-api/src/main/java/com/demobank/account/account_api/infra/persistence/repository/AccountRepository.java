package com.demobank.account.account_api.infra.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demobank.account.account_api.infra.persistence.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID>{
    
    List<AccountEntity> findAllByCustomerId(UUID id);
}
