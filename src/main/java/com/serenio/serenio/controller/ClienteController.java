package com.serenio.serenio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.serenio.serenio.DTO.ClienteDTO;
import com.serenio.serenio.model.Cliente;
import com.serenio.serenio.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> listarClientes(Cliente cliente) {
        return clienteService.listarClientes(cliente);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCliente(@RequestBody ClienteDTO clienteDTO){
        clienteService.cadastrarCliente(clienteDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarClienteById(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO){
        clienteService.atualizarClienteById(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarClienteById(@PathVariable Integer id){
        clienteService.deletarClienteById(id);
    }

}
