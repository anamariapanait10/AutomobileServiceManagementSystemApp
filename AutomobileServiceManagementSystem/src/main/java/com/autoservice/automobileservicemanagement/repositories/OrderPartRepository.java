package com.autoservice.automobileservicemanagement.repositories;

import com.autoservice.automobileservicemanagement.model.entities.OrderPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderPartRepository extends JpaRepository<OrderPart, Long> {

    List<OrderPart> findAllByOrderId(Long orderId);

}
