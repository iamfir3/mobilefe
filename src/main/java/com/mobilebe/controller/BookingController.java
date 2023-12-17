package com.mobilebe.controller;

import com.mobilebe.dto.BookingDTO;
import com.mobilebe.entity.BookingEntity;
import com.mobilebe.entity.RoomDetailEntity;
import com.mobilebe.entity.SystemUserEntity;
import com.mobilebe.repository.BookingRepository;
import com.mobilebe.repository.RoomRepository;
import com.mobilebe.repository.SystemUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private SystemUserRepository systemUserRepository;

    @PostMapping
    private ResponseEntity<?> book(@RequestBody BookingDTO bookingDTO){
        BookingEntity bookingEntity=new BookingEntity();
        BeanUtils.copyProperties(bookingDTO,bookingEntity);
        RoomDetailEntity roomDetail=roomRepository.findById(bookingDTO.getRoomId()).get();
        SystemUserEntity user=systemUserRepository.findById(bookingDTO.getUserId()).get();
        bookingEntity.setRoomDetail(roomDetail);
        bookingEntity.setUser(user);
        bookingEntity.set_paid(false);
        bookingRepository.save(bookingEntity);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/getHistory")
    private ResponseEntity<?> getHistory(@RequestParam Long userId){
        List<BookingEntity> bookingEntities=bookingRepository.findAllByUserId(userId);
        List<BookingDTO> returnValue=bookingEntities.stream().map(bookingEntity -> {
            BookingDTO bookingDTO=new BookingDTO();
            BeanUtils.copyProperties(bookingEntity,bookingDTO);
            return bookingDTO;
        }).toList();
        return ResponseEntity.ok(returnValue);
    }
}
