package com.mobilebe.controller;

import com.mobilebe.dto.GetAllUserByAdminResponse;
import com.mobilebe.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @GetMapping
    private ResponseEntity<GetAllUserByAdminResponse> getAllUserByAdmin() {
        return ResponseEntity.ok(
                GetAllUserByAdminResponse.builder()
                        .systemUserEntityList(systemUserRepository.findAll())
                        .build()
        );
    }

    @GetMapping("/search")
    private ResponseEntity<GetAllUserByAdminResponse> searchUser(@RequestParam("keyword") String keyword){
        return ResponseEntity.ok(
                GetAllUserByAdminResponse.builder()
                        .systemUserEntityList(systemUserRepository.searchByUsername(keyword))
                        .build()
        );
    }
}
