package com.API.billetera.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PendingTransactionRequestDTO{
    /**
     * creamos el dto request transacion pendiente 
     */
    private String sessionId;
    
    private String token;
    
    private BigDecimal amount;
}