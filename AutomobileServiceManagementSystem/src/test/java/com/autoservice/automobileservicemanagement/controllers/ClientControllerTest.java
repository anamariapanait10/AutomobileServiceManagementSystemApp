package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.ClientDto;
import com.autoservice.automobileservicemanagement.mocks.ClientEntitiesMocks;
import com.autoservice.automobileservicemanagement.mappers.ClientMapper;
import com.autoservice.automobileservicemanagement.services.ClientService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {
    @InjectMocks
    ClientController clientController;

    @Mock
    ClientService clientService;

    @Test
    public void testGetAllClientsHappyUsecase() {
        when(clientService.getAllClients()).thenReturn(ClientEntitiesMocks.getClientsMock().stream()
                .map(ClientMapper::mapClientToDto).toList());

        ResponseEntity<List<ClientDto>> result = clientController.getAllClients();
        assert result.getStatusCode().is2xxSuccessful();
        assertNotNull(result.getBody());
        assertEquals(2, result.getBody().size());
    }

    @Test
    public void testGetClientByIdHappyUsecase() {
        when(clientService.getClientById(1L))
                .thenReturn(ClientMapper.mapClientToDto(ClientEntitiesMocks.getClientsMock().get(0)));

        ResponseEntity<ClientDto> result = clientController.getClientById(1L);
        assert result.getStatusCode().is2xxSuccessful();
        assertEquals("John Doe", result.getBody().getFullName());
    }

    @Test
    public void testGetClientByIdUnhappyUsecase() {
        when(clientService.getClientById(999L)).thenThrow(new RuntimeException("Client not found"));

        assertThrows(RuntimeException.class, () -> {
            clientController.getClientById(999L);
        });
    }

    @Test
    public void testAddClientHappyUsecase() {
        ClientDto clientDto = ClientMapper.mapClientToDto(ClientEntitiesMocks.getClientsMock().get(0));
        when(clientService.addClient(clientDto)).thenReturn(clientDto);

        ResponseEntity<ClientDto> result = clientController.addClient(clientDto);
        assert result.getStatusCode().is2xxSuccessful();
        assertEquals("John Doe", result.getBody().getFullName());
    }
}
