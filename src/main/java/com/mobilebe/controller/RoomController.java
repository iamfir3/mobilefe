package com.mobilebe.controller;

import com.mobilebe.dto.RoomDTO;
import com.mobilebe.dto.RoomStatus;
import com.mobilebe.entity.BookingEntity;
import com.mobilebe.entity.RoomDetailEntity;
import com.mobilebe.repository.BookingRepository;
import com.mobilebe.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("room")
public class RoomController
{
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    private ResponseEntity<?> getAllRoom(@RequestParam("startDate")Date startDate, @RequestParam("endDate") Date endDate, @RequestParam("status")RoomStatus status){
        List<RoomDTO> returnValue=new ArrayList<>();

        if(status.equals(RoomStatus.AVAILABLE)){
            List<RoomDetailEntity> roomDetails=roomRepository.findAvailableRooms(startDate,endDate);
            roomDetails.forEach(roomDetailEntity -> {
                RoomDTO roomDTO= RoomDTO.builder()
                        .id(roomDetailEntity.getId())
                        .room_price(roomDetailEntity.getRoom_price())
                        .room_number(roomDetailEntity.getRoom_number())
                        .room_floor(roomDetailEntity.getRoom_floor())
                        .room_type(roomDetailEntity.getRoom_type())
                        .room_desciption(roomDetailEntity.getRoom_desciption())
                        .number_of_beds(roomDetailEntity.getNumber_of_beds())
                        .room_price(roomDetailEntity.getRoom_price())
                        .build();
                returnValue.add(roomDTO);
            });
        } else if(status.equals(RoomStatus.BOOKED)){
            List<BookingEntity> bookingEntities=bookingRepository.findBookingsInDateRange(startDate,endDate);
            bookingEntities.forEach(bookingEntity -> {
                RoomDTO roomDTO=RoomDTO.builder()
                        .id(bookingEntity.getRoomDetail().getId())
                        .room_price(bookingEntity.getRoomDetail().getRoom_price())
                        .room_number(bookingEntity.getRoomDetail().getRoom_number())
                        .room_floor(bookingEntity.getRoomDetail().getRoom_floor())
                        .room_type(bookingEntity.getRoomDetail().getRoom_type())
                        .room_desciption(bookingEntity.getRoomDetail().getRoom_desciption())
                        .number_of_beds(bookingEntity.getRoomDetail().getNumber_of_beds())
                        .room_price(bookingEntity.getRoomDetail().getRoom_price())
                        .build();
                returnValue.add(roomDTO);
            });
        }
        return ResponseEntity.ok(returnValue);
    }
}