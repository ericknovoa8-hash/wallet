package com.API.billetera.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
/** 
 * creamos el dto para debitar el saldo en el momento de hacer una compra. 
 */
public class PayWalletRequestDTO {

    private String documentNumber;
    
    private String phoneNumber;

    private BigDecimal amount;
}
