package com.autoservice.automobileservicemanagement.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "car_model_id")
    private Long carModelId;

    @Column(name = "date")
    private LocalDate orderDate;

    @Column(name = "status")
    private String status;
}
