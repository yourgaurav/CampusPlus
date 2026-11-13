package com.gauav.CampusPlus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable=false , length = 100)
    private String name;
    @Column(nullable=false,unique = true ,length = 150)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false , length=30)
    private UserRole role;
}
