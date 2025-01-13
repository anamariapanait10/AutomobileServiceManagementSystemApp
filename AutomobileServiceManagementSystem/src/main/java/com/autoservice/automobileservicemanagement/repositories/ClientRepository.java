package com.autoservice.automobileservicemanagement.repositories;

import com.autoservice.automobileservicemanagement.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
