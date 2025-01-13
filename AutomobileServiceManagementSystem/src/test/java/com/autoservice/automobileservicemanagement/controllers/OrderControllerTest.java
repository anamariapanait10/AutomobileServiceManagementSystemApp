package com.autoservice.automobileservicemanagement.controllers;

import com.autoservice.automobileservicemanagement.dto.OrderDto;
import com.autoservice.automobileservicemanagement.dto.OrderPartDto;
import com.autoservice.automobileservicemanagement.mocks.OrderEntitiesMocks;
import com.autoservice.automobileservicemanagement.services.OrderService;

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
public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @Test
    public void testGetOrderByIdHappyUsecase() {
        when(orderService.getOrderById(1L)).thenReturn(OrderEntitiesMocks.getOrderDtoMock());

        ResponseEntity<OrderDto> response = orderController.getOrderById(1L);
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    public void testGetAllOrdersHappyUsecase() {
        when(orderService.getAllOrders()).thenReturn(OrderEntitiesMocks.getOrderDtoListMock());

        ResponseEntity<List<OrderDto>> response = orderController.getAllOrders();
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testAddOrderHappyUsecase() {
        OrderDto orderDto = OrderEntitiesMocks.getOrderDtoMock();
        when(orderService.addOrder(orderDto)).thenReturn(orderDto);

        ResponseEntity<OrderDto> response = orderController.addOrder(orderDto);
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
    }
}
