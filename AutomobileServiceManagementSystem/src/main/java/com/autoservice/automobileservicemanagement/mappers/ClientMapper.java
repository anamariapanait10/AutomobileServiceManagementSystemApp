package com.autoservice.automobileservicemanagement.mappers;

import com.autoservice.automobileservicemanagement.dto.ClientDto;
import com.autoservice.automobileservicemanagement.model.entities.Client;

public class ClientMapper {

    public static ClientDto mapClientToDto(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .fullName(client.getFullName())
                .address(client.getAddress())
                .phone(client.getPhone())
                .build();
    }

    public static Client mapDtoToClient(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }
        return Client.builder()
                .id(clientDto.getId())
                .fullName(clientDto.getFullName())
                .address(clientDto.getAddress())
                .phone(clientDto.getPhone())
                .build();
    }

}
