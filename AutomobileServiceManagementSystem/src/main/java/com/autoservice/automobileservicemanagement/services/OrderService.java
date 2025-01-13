package com.autoservice.automobileservicemanagement.services;

import com.autoservice.automobileservicemanagement.dto.OrderDto;
import com.autoservice.automobileservicemanagement.dto.OrderPartDto;
import com.autoservice.automobileservicemanagement.model.entities.Order;
import com.autoservice.automobileservicemanagement.model.entities.OrderPart;
import com.autoservice.automobileservicemanagement.exception.DataNotFoundException;
import com.autoservice.automobileservicemanagement.repositories.OrderPartRepository;
import com.autoservice.automobileservicemanagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderPartRepository orderPartRepository;

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(order -> {
            List<OrderPartDto> orderParts = orderPartRepository.findAllByOrderId(order.getId()).stream().map(op -> OrderPartDto.builder()
                    .id(op.getId())
                    .orderId(op.getOrderId())
                    .partId(op.getPartId())
                    .quantity(op.getQuantity())
                    .build()).toList();
            return OrderDto.builder()
                    .id(order.getId())
                    .employeeId(order.getEmployeeId())
                    .clientId(order.getClientId())
                    .orderDate(order.getOrderDate())
                    .carModelId(order.getCarModelId())
                    .orderParts(orderParts)
                    .status(order.getStatus())
                    .build();
        }).toList();
    }

    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            List<OrderPartDto> orderParts = orderPartRepository.findAllByOrderId(orderId).stream().map(op -> OrderPartDto.builder()
                    .id(op.getId())
                    .orderId(op.getOrderId())
                    .partId(op.getPartId())
                    .quantity(op.getQuantity())
                    .build()).toList();

            return OrderDto.builder()
                    .id(order.getId())
                    .employeeId(order.getEmployeeId())
                    .clientId(order.getClientId())
                    .orderDate(order.getOrderDate())
                    .carModelId(order.getCarModelId())
                    .orderParts(orderParts)
                    .status(order.getStatus())
                    .build();
        }
        throw new DataNotFoundException("Order not found");
    }

    public OrderDto addOrder(OrderDto orderDto) {
        Order order = Order.builder()
                .employeeId(orderDto.getEmployeeId())
                .clientId(orderDto.getClientId())
                .orderDate(orderDto.getOrderDate())
                .carModelId(orderDto.getCarModelId())
                .status(orderDto.getStatus())
                .build();
        order = orderRepository.save(order);
        List<OrderPartDto> orderParts = orderDto.getOrderParts();
        List<OrderPart> savedParts = new ArrayList<>();
        for (OrderPartDto orderPartDto : orderParts) {
            OrderPart orderPart = OrderPart.builder()
                    .orderId(order.getId())
                    .partId(orderPartDto.getPartId())
                    .quantity(orderPartDto.getQuantity())
                    .build();
            savedParts.add(orderPartRepository.save(orderPart));
        }
        return OrderDto.builder()
                .id(order.getId())
                .employeeId(order.getEmployeeId())
                .clientId(order.getClientId())
                .orderDate(order.getOrderDate())
                .carModelId(order.getCarModelId())
                .orderParts(savedParts.stream().map(op -> OrderPartDto.builder().id(op.getId()).orderId(op.getOrderId())
                        .partId(op.getPartId()).quantity(op.getQuantity()).build()).toList())
                .status(order.getStatus())
                .build();
    }

}
