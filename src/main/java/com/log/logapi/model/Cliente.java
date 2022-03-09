package com.log.logapi.model;

import lombok.Data;

@Data
public class Cliente {
    
    private Long id;
    private String nome;
    private String telefone;
    private String email;
}
