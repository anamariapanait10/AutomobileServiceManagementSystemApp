package com.autoservice.automobileservicemanagement.mocks;

import com.autoservice.automobileservicemanagement.dto.OrderDto;
import com.autoservice.automobileservicemanagement.dto.OrderPartDto;
import com.autoservice.automobileservicemanagement.model.entities.Order;
import com.autoservice.automobileservicemanagement.model.entities.OrderPart;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderEntitiesMocks {

    public static Order getOrderMock() {
        return Order.builder()
                .id(1L)
                .clientId(1L)
                .employeeId(2L)
                .carModelId(3L)
                .orderDate(LocalDate.of(2023, 1, 1))
                .status("PENDING")
                .build();
    }

    public static List<Order> getOrderListMock() {
        List<Order> orders = new ArrayList<>();
        orders.add(getOrderMock());
        orders.add(Order.builder()
                .id(2L)
                .clientId(2L)
                .employeeId(3L)
                .carModelId(4L)
                .orderDate(LocalDate.of(2023, 2, 1))
                .status("COMPLETED")
                .build());
        return orders;
    }

    public static List<OrderPart> getOrderPartListMock() {
        List<OrderPart> orderParts = new ArrayList<>();
        orderParts.add(OrderPart.builder()
                .id(1L)
                .orderId(1L)
                .partId(1L)
                .quantity(2)
                .build());
        orderParts.add(OrderPart.builder()
                .id(2L)
                .orderId(1L)
                .partId(2L)
                .quantity(4)
                .build());
        return orderParts;
    }

    public static OrderDto getOrderDtoMock() {
        return OrderDto.builder()
                .id(1L)
                .clientId(1L)
                .employeeId(2L)
                .carModelId(3L)
                .orderDate(LocalDate.of(2023, 1, 1))
                .status("PENDING")
                .orderParts(getOrderPartDtoListMock())
                .build();
    }

    public static List<OrderDto> getOrderDtoListMock() {
        List<OrderDto> orders = new ArrayList<>();
        orders.add(getOrderDtoMock());
        orders.add(OrderDto.builder()
                .id(2L)
                .clientId(2L)
                .employeeId(3L)
                .carModelId(4L)
                .orderDate(LocalDate.of(2023, 2, 1))
                .status("COMPLETED")
                .orderParts(new ArrayList<>())
                .build());
        return orders;
    }

    public static List<OrderPartDto> getOrderPartDtoListMock() {
        List<OrderPartDto> orderParts = new ArrayList<>();
        orderParts.add(OrderPartDto.builder()
                .id(1L)
                .orderId(1L)
                .partId(1L)
                .quantity(2)
                .build());
        orderParts.add(OrderPartDto.builder()
                .id(2L)
                .orderId(1L)
                .partId(2L)
                .quantity(4)
                .build());
        return orderParts;
    }
}
