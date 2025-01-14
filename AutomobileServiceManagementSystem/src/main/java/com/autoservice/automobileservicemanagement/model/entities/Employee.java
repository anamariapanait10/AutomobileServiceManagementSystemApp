package com.autoservice.automobileservicemanagement.model.entities;

import com.autoservice.automobileservicemanagement.validator.OnlyLetters;
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
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    @NotNull(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @Column(name = "full_name", nullable = false)
    @NotNull(message = "Full name is required")
    @OnlyLetters
    private String fullName;

    @Column(name = "user_type", nullable = false)
    @NotNull(message = "User type is required")
    @Pattern(regexp = "ADMIN|USER|MANAGER", message = "User type must be ADMIN, USER, or MANAGER")
    private String userType;
}
