package com.mobilebe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String hotel_name;
    private String hotel_location;
    private String manager_name;

    @OneToMany(mappedBy = "hotel",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<RoomDetailEntity> roomDetailEntityList;
}
