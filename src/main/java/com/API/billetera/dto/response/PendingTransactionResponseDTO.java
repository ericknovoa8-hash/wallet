package com.API.billetera.dto.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PendingTransactionResponseDTO {
    /**
     * creamos el dto de transacion pendiente response 
     */
    
    private Long id;

    private String sessionId;
    
    private String token;
    
    private BigDecimal amount;
    
}
