package com.mobilebe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private Long id;
    private String roomNumber;
    private int num_of_rooms;
    private int num_of_adults;
    private int num_of_children;
    private Date check_in_date;
    private Date check_out_date;
    private int num_of_days;
    private int total_price;
    private int tax;
    private int billed_price;
    private boolean is_paid;
    private boolean is_active;

    private Long roomId;
    private Long userId;
}
