package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.OrderDto;
import com.autoservice.automobileservicemanagement.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "Order Management", description = "APIs for managing orders")
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Get an order by ID", description = "Retrieve order details by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        OrderDto o = orderService.getOrderById(id);
        return ResponseEntity.ok(o);
    }

    @Operation(summary = "Get all orders", description = "Retrieve a list of all orders")
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> o = orderService.getAllOrders();
        return ResponseEntity.ok(o);
    }

    @Operation(summary = "Add a new order", description = "Add a new order to the system")
    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {
        OrderDto o = orderService.addOrder(orderDto);
        return o != null ? ResponseEntity.ok(o) : ResponseEntity.notFound().build();
    }
}
