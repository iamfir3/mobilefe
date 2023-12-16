package com.mobilebe.dto;

import com.mobilebe.entity.BookingEntity;
import com.mobilebe.entity.Hotel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoomDTO {
    private Long id;

    private String room_number;
    private int room_floor;
    private String room_type;
    private int room_price;
    private String room_desciption;
    private int number_of_beds;
    private String room_status;

}
