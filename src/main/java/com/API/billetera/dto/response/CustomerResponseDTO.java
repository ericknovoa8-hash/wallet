package com.API.billetera.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerResponseDTO {
    /**
     * creamos los response de customer
     */
    private Long id;
    
    @NotBlank(message = "Es obligatorio el numero del documento")
    private String documentNumber;
    
    @NotBlank(message = "Es obligatorio el Nombre del cliente")
    private String fullName;
    
    @Email(message = "Ingresa el correo electronico valido ")
    @NotBlank(message = "El correo electronico es obligatorio")
    private String email;

    private String phoneNumber;
}
