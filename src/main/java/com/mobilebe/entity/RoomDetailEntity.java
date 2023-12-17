package com.mobilebe.entity;

import com.mobilebe.dto.RoomStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private RoomStatus room_status;

    @ManyToOne
    private SystemUserEntity createdBy;

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    @OneToMany(mappedBy = "roomDetail")
    private List<BookingEntity> bookingEntity;
}
