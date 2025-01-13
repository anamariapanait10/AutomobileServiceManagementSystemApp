package com.autoservice.automobileservicemanagement.services;

import com.autoservice.automobileservicemanagement.dto.OrderDto;
import com.autoservice.automobileservicemanagement.dto.OrderPartDto;
import com.autoservice.automobileservicemanagement.exception.DataNotFoundException;
import com.autoservice.automobileservicemanagement.mocks.OrderEntitiesMocks;
import com.autoservice.automobileservicemanagement.model.entities.Order;
import com.autoservice.automobileservicemanagement.model.entities.OrderPart;
import com.autoservice.automobileservicemanagement.repositories.OrderPartRepository;
import com.autoservice.automobileservicemanagement.repositories.OrderRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderPartRepository orderPartRepository;

    @Test
    public void testGetOrderByIdHappyUsecase() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(OrderEntitiesMocks.getOrderMock()));
        when(orderPartRepository.findAllByOrderId(1L)).thenReturn(OrderEntitiesMocks.getOrderPartListMock());

        OrderDto result = orderService.getOrderById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testGetOrderByIdUnhappyUsecase() {
        when(orderRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> {
            orderService.getOrderById(999L);
        });
    }

    @Test
    public void testGetAllOrdersHappyUsecase() {
        when(orderRepository.findAll()).thenReturn(OrderEntitiesMocks.getOrderListMock());
        when(orderPartRepository.findAllByOrderId(anyLong())).thenReturn(OrderEntitiesMocks.getOrderPartListMock());

        List<OrderDto> result = orderService.getAllOrders();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testAddOrderHappyUsecase() {
        Order order = OrderEntitiesMocks.getOrderMock();
        List<OrderPart> orderParts = OrderEntitiesMocks.getOrderPartListMock();

        when(orderRepository.save(any(Order.class))).thenReturn(order);
        when(orderPartRepository.save(any(OrderPart.class))).thenReturn(orderParts.get(0));

        OrderDto result = orderService.addOrder(OrderEntitiesMocks.getOrderDtoMock());
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }
}
