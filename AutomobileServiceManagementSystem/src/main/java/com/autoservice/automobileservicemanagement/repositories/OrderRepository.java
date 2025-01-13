package com.autoservice.automobileservicemanagement.repositories;

import com.autoservice.automobileservicemanagement.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
