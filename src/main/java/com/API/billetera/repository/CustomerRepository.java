package com.API.billetera.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.billetera.entity.Customer;

@Repository
/**
 * creamos el repository con estencion de jpaRepository de customer
 * CustomerRepository
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByDocumentNumber(String documentNumber);

    List<Customer> findByFullName(String name);
    
}
