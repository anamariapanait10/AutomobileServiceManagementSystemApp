package com.autoservice.automobileservicemanagement.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car_parts")
public class CarPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "Name is required")
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    private String name;

    @Column(name = "part_number", nullable = false, unique = true)
    @NotNull(message = "Part number is required")
    @Size(min = 1, max = 50, message = "Part number must be between 1 and 50 characters")
    private String partNumber;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be at least 1")
    private Integer price;

    @Column(name = "quantity", nullable = false)
    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

    @Column(name = "car_model_id", nullable = false)
    @NotNull(message = "Car model ID is required")
    private Long carModelId;
}
