package com.example.review.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "restaurant")
@Entity

public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

//    @PrePersist
//    public void createdAt() {
//        ZonedDateTime now = ZonedDateTime.now();
//        createdAt = now;
//        updatedAt = now;
//    }
//
//    @PreUpdate
//    public void updatedAt() {
//        ZonedDateTime now = ZonedDateTime.now();
//        updatedAt = now;
//    }

    public void updateNameAndAddress(String name, String address) {
        this.name = name;
        this.address = address;
    }

}
