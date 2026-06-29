package com.API.billetera.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
/**
 * Creamos el paquete de recargar la billetera para que no tengamos confuciones al momento de hacer
 * recargas en la billetera y que la app funcione de la mejor manera.
 * WalletRechargeRequestDTO
 */
public class WalletRechargeRequestDTO {
    private Long customerId;
    private BigDecimal amount;
    
}
