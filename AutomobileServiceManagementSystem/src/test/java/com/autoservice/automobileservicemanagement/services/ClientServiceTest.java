package com.autoservice.automobileservicemanagement.services;

import com.autoservice.automobileservicemanagement.dto.ClientDto;
import com.autoservice.automobileservicemanagement.exception.DataNotFoundException;
import com.autoservice.automobileservicemanagement.mappers.ClientMapper;
import com.autoservice.automobileservicemanagement.mocks.ClientEntitiesMocks;
import com.autoservice.automobileservicemanagement.model.entities.Client;
import com.autoservice.automobileservicemanagement.repositories.ClientRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    ClientService clientService;

    @Mock
    ClientRepository clientRepository;

    @Test
    public void testGetAllClientsHappyUsecase() {
        when(clientRepository.findAll()).thenReturn(ClientEntitiesMocks.getClientsMock());

        List<ClientDto> result = clientService.getAllClients();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetClientByIdHappyUsecase() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(ClientEntitiesMocks.getClientsMock().get(0)));

        ClientDto result = clientService.getClientById(1L);
        assertEquals("John Doe", result.getFullName());
    }

    @Test
    public void testGetClientByIdUnhappyUsecase() {
        when(clientRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> {
            clientService.getClientById(999L);
        });
    }

    @Test
    public void testAddClientHappyUsecase() {
        Client client = ClientEntitiesMocks.getClientsMock().get(0);
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        ClientDto result = clientService.addClient(ClientMapper.mapClientToDto(client));
        assertEquals("John Doe", result.getFullName());
    }
}
