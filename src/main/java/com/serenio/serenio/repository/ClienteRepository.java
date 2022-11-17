package com.serenio.serenio.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serenio.serenio.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    Optional<String> findByCpf(String cpf);

    Optional<String> findByEmail(String email);

}
