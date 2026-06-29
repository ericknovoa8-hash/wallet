package com.API.billetera.dto.request;

import lombok.Data;

@Data
public class CustomerRequestDTO {
    /**
     * creamos los dto request de customer 
     */
    private String documentNumber;

    private String fullName;

    private String email;

    private String phoneNumber;
    
}
