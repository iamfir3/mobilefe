package com.mobilebe.entity;

import com.mobilebe.util.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SystemUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
    private String streetAddress;
    private String city;
    private String state;
    private String zipcode;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<CardDetailEntity> cardDetailEntities;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<BookingEntity> bookingEntities;

    @OneToMany(mappedBy = "createdBy")
    private List<RoomDetailEntity> createdRoom;
}
