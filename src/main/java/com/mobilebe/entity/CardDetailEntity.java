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
public class CardDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nameOnCard;
    private String cardType;
    private String cardNum;
    private Date expiryDate;

    @ManyToOne
    private SystemUserEntity user;
}
