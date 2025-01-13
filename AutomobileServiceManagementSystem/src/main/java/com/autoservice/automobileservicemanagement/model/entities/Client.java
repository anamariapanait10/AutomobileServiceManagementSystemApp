package com.autoservice.automobileservicemanagement.model.entities;

import com.autoservice.automobileservicemanagement.validator.OnlyLetters;
import jakarta.persistence.*;
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

    @Column(name = "full_name")
    @OnlyLetters
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;
}
