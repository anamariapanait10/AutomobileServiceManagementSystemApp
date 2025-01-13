package com.autoservice.automobileservicemanagement.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_parts")
public class OrderPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "part_id")
    private Long partId;

    @Column(name = "quantity")
    private Integer quantity;
}
