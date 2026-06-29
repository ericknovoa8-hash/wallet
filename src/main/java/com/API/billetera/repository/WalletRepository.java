package com.API.billetera.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.billetera.entity.Wallet;
import java.math.BigDecimal;


@Repository
/**
 * 
 * WalletRepository
 */
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    
    Optional<Wallet> findByCustomerId(Long customerId);
    List<Wallet> findBySaldo(BigDecimal saldo);
}
