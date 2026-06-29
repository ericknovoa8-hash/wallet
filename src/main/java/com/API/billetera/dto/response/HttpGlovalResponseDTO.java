package com.API.billetera.dto.response;

import lombok.Data;

@Data
public class HttpGlovalResponseDTO<T> {
    /**  
    * DTO Genérico para la estandarización de respuestas HTTP de la API Billetera.
    */
    private String message;
    private T data;
}
