package com.autoservice.automobileservicemanagement.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @Column(name = "client_id", nullable = false)
    @NotNull(message = "Client ID is required")
    private Long clientId;

    @Column(name = "employee_id", nullable = false)
    @NotNull(message = "Employee ID is required")
    private Long employeeId;

    @Column(name = "car_model_id", nullable = false)
    @NotNull(message = "Car model ID is required")
    private Long carModelId;

    @Column(name = "date", nullable = false)
    @NotNull(message = "Order date is required")
    private LocalDate orderDate;

    @Column(name = "status", nullable = false)
    @NotNull(message = "Status is required")
    @Pattern(regexp = "PENDING|COMPLETED|CANCELLED", message = "Status must be PENDING, COMPLETED, or CANCELLED")
    private String status;
}
