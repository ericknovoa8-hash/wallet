package com.API.billetera.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.billetera.entity.PendingTransaction;

@Repository
/**
 * repository de transacion pendiente 
 * PendingTransactionRepository
 */
public interface PendingTransactionRepository extends JpaRepository<PendingTransaction, Long> {
    Optional<PendingTransaction> findBySessionId(String sessionId);
    
}
