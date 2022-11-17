package com.serenio.serenio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.serenio.serenio.DTO.ClienteDTO;
import com.serenio.serenio.model.Cliente;
import com.serenio.serenio.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    //Transform MODEL to DTO.
    public ClienteDTO toClienteDTO(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDTO.class);
    }
    
    public List<ClienteDTO> listarClientes(Cliente cliente) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.EXACT);
        Example<Cliente> c = Example.of(cliente, matcher);
        return clienteRepository.findAll(c).stream().map(this::toClienteDTO).collect(Collectors.toList());
    }

    public void cadastrarCliente(ClienteDTO dto) {
        if(clienteRepository.findByCpf(dto.getCpf()).isEmpty() && dto.getCpf().length() == 11) {

            Cliente cliente = new Cliente();
            cliente.setId(dto.getIdCliente());
            cliente.setNome(dto.getNome());
            cliente.setSobrenome(dto.getSobrenome());
            cliente.setEmail(dto.getEmail());
            cliente.setCpf(dto.getCpf());
            cliente.setSituacao(dto.getSituacao());
            cliente.setSaldo(dto.getSaldo());
            clienteRepository.save(cliente);

        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já registrado. ");
        }
        
    }

    public void deletarClienteById(Integer id) {
        clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Cliente não localizado"));
        clienteRepository.deleteById(id);
    }
}
