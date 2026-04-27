package com.donavida.donavida.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aesthetic_centers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AestheticCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    private String city;

    private boolean verified = false;
}