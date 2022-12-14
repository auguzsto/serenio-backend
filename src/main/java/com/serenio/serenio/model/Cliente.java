package com.serenio.serenio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = true)
    private Integer situacao;

    @Column(nullable = true)
    private Integer saldo;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    }

