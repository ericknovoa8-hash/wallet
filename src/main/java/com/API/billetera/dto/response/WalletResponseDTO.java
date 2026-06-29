package com.API.billetera.dto.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class WalletResponseDTO {
    /**
     * creamos el response de billetera 
     */
    private Long id;
    
    private Long customerId;
    
    private BigDecimal balance;
}
