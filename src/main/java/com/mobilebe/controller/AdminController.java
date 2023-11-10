package com.mobilebe.controller;

import com.mobilebe.dto.GetAllUserByAdminResponse;
import com.mobilebe.dto.GetUser;
import com.mobilebe.dto.UpdateUserCommand;
import com.mobilebe.entity.SystemUserEntity;
import com.mobilebe.exception.ApiException;
import com.mobilebe.repository.SystemUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/searchByLastname")
    private ResponseEntity<GetAllUserByAdminResponse> searchUserByLastname(@RequestParam("keyword") String keyword){
        return ResponseEntity.ok(
                GetAllUserByAdminResponse.builder()
                        .systemUserEntityList(systemUserRepository.searchByLastname(keyword))
                        .build()
        );
    }

    @DeleteMapping("/delete")
    private ResponseEntity<?> deleteUser(@RequestParam("id") Long id){
        systemUserRepository.deleteById(id);
        return ResponseEntity.ok("Success");
    }

    @PutMapping("/update")
    private ResponseEntity<GetUser> updateUser(@RequestBody UpdateUserCommand updateUserCommand){
        Optional<SystemUserEntity> systemUserEntity=systemUserRepository.findById(updateUserCommand.getId());
        if(systemUserEntity.isEmpty()){
            throw new ApiException(HttpStatus.BAD_REQUEST,"Can't find user");
        }
        BeanUtils.copyProperties(updateUserCommand,systemUserEntity.get());
        systemUserRepository.save(systemUserEntity.get());
        GetUser getUser=new GetUser();
        BeanUtils.copyProperties(systemUserEntity.get(),getUser);
        return ResponseEntity.ok(getUser);

    }
}
