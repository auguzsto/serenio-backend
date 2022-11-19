package com.serenio.serenio.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    
    private Integer idCliente;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private Integer situacao;
    private Integer saldo;

}
