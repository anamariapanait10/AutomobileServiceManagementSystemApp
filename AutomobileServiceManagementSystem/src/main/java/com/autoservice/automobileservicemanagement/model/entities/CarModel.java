package com.autoservice.automobileservicemanagement.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car_models")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false)
    @NotNull(message = "Brand is required")
    @Size(min = 1, max = 50, message = "Brand must be between 1 and 50 characters")
    private String brand;

    @Column(name = "model", nullable = false)
    @NotNull(message = "Model is required")
    @Size(min = 1, max = 50, message = "Model must be between 1 and 50 characters")
    private String model;

    @Column(name = "year", nullable = false)
    @NotNull(message = "Year is required")
    @Pattern(regexp = "\\d{4}", message = "Year must be a valid 4-digit number")
    private String year;

    @Column(name = "engine", nullable = false)
    @NotNull(message = "Engine is required")
    @Size(min = 1, max = 100, message = "Engine must be between 1 and 100 characters")
    private String engine;
}
