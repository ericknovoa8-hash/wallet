package com.API.billetera.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class WalletRequestDTO {
    /**
     * creamos el request de billetera 
     */
    private Long customerId;
    
    private BigDecimal balance;
}
