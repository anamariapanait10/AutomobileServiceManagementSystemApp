package com.autoservice.automobileservicemanagement.mocks;

import com.autoservice.automobileservicemanagement.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientEntitiesMocks {

    public static List<Client> getClientsMock() {
        Client client1 = Client.builder()
                .id(1L)
                .fullName("John Doe")
                .address("123 Main St")
                .phone("555-1234")
                .build();

        Client client2 = Client.builder()
                .id(2L)
                .fullName("Jane Smith")
                .address("456 Elm St")
                .phone("555-5678")
                .build();

        List<Client> clientList = new ArrayList<>();
        clientList.add(client1);
        clientList.add(client2);
        return clientList;
    }
}
