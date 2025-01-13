package com.autoservice.automobileservicemanagement.model.entities;

import com.autoservice.automobileservicemanagement.validator.OnlyLetters;
import jakarta.persistence.*;
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

    @Column(name = "username")
    private String username;

    @Column(name = "full_name")
    @OnlyLetters
    private String fullName;

    @Column(name = "user_type")
    private String userType;
}
