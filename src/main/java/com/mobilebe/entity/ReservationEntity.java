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
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String reservation_date;
    private String billing_address;
    private boolean is_canceled;
    private String res_status;

    @OneToOne
    private BookingEntity bookingEntity;

}
