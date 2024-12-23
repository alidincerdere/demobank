package com.demobank.transaction.transaction_api.infra.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demobank.transaction.transaction_api.infra.persistence.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, UUID>{

    List<TransactionEntity> findAllByAccountId(UUID accountId);
    
}
