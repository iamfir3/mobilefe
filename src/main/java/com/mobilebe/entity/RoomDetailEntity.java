package com.mobilebe.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String room_number;
    private int room_floor;
    private String room_type;
    private int room_price;
    private String room_desciption;
    private int number_of_beds;
    private String room_status;

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    @OneToOne
    private BookingEntity bookingEntity;
}