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
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    @NotNull(message = "Full name is required")
    @OnlyLetters
    private String fullName;

    @Column(name = "address", nullable = false)
    @NotNull(message = "Address is required")
    @Size(min = 5, max = 255, message = "Address must be between 5 and 255 characters")
    private String address;

    @Column(name = "phone", nullable = false, unique = true)
    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "\\+?[0-9]{10,15}", message = "Phone number must be valid and between 10 to 15 digits")
    private String phone;
}
