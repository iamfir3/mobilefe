package com.mobilebe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int num_of_rooms;
    private int num_of_adults;
    private int num_of_children;
    private String check_in_date;
    private String check_out_date;
    private int num_of_days;
    private int total_price;
    private int tax;
    private int billed_price;
    private boolean is_paid;
    private boolean is_active;

    @ManyToOne
    private RoomDetailEntity roomDetail;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private ReservationEntity reservationEntity;

    @ManyToOne
    private SystemUserEntity user;
}
