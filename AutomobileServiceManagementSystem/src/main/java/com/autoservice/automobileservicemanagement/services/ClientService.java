package com.autoservice.automobileservicemanagement.services;

import com.autoservice.automobileservicemanagement.dto.ClientDto;
import com.autoservice.automobileservicemanagement.model.entities.Client;
import com.autoservice.automobileservicemanagement.exception.DataNotFoundException;
import com.autoservice.automobileservicemanagement.mappers.ClientMapper;
import com.autoservice.automobileservicemanagement.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream().map(ClientMapper::mapClientToDto).collect(Collectors.toList());
    }

    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client == null) {
            throw new DataNotFoundException("Client with id " + id + " not found");
        }
        return ClientMapper.mapClientToDto(client);
    }

    public ClientDto addClient(ClientDto clientDto) {
        return ClientMapper.mapClientToDto(clientRepository.save(ClientMapper.mapDtoToClient(clientDto)));
    }

}
