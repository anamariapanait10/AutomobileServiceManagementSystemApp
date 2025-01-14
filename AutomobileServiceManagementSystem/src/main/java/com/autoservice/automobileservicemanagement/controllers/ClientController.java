package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.ClientDto;
import com.autoservice.automobileservicemanagement.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Tag(name = "Client Management", description = "Manage clients and their details")
public class ClientController {

    private final ClientService clientService;

    @Operation(summary = "Get all clients", description = "Retrieve a list of all registered clients")
    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @Operation(summary = "Get a client by ID", description = "Retrieve details of a client by their unique ID")
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @Operation(summary = "Add a new client", description = "Add a new client to the system")
    @PostMapping
    public ResponseEntity<ClientDto> addClient(@RequestBody @Valid ClientDto clientDto) {
        return ResponseEntity.ok(clientService.addClient(clientDto));
    }
}
