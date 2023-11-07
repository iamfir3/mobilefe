package com.mobilebe.controller;

import com.mobilebe.dto.LoginCommand;
import com.mobilebe.dto.LoginResponse;
import com.mobilebe.dto.RegisterCommand;
import com.mobilebe.dto.RegisterResponse;
import com.mobilebe.entity.CardDetailEntity;
import com.mobilebe.entity.SystemUserEntity;
import com.mobilebe.exception.ApiException;
import com.mobilebe.repository.CardDetailRepository;
import com.mobilebe.repository.SystemUserRepository;
import com.mobilebe.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private CardDetailRepository cardDetailRepository;

    @PostMapping
    private ResponseEntity<LoginResponse> login(@RequestBody LoginCommand loginCommand){
        Optional<SystemUserEntity> systemUserEntity=systemUserRepository.findByUsername(loginCommand.getUsername());
        if(systemUserEntity.isEmpty()){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Incorred username or password");
        }
        return ResponseEntity.ok(LoginResponse.builder()
                        .firstName(systemUserEntity.get().getFirstName())
                        .lastName(systemUserEntity.get().getLastName())
                        .role(systemUserEntity.get().getRole())
                .build());
    }

    @PostMapping("/register")
    private ResponseEntity<RegisterResponse> register(@RequestBody RegisterCommand registerCommand){
        Optional<SystemUserEntity> systemUserEntity=systemUserRepository.findByUsername(registerCommand.getReg_user());
        if (systemUserEntity.isPresent()){
            throw new ApiException(HttpStatus.BAD_REQUEST,"Existed user");
        }
        Optional<CardDetailEntity> cardDetailEntity=cardDetailRepository.findByCardNum(registerCommand.getCard_num());
        if(cardDetailEntity.isPresent()){
            throw new ApiException(HttpStatus.BAD_REQUEST,"Existed card");
        }

        CardDetailEntity cardDetailEntity1= CardDetailEntity.builder()
                .expiryDate(registerCommand.getExpiry_date())
                .cardNum(registerCommand.getCard_num())
                .cardType(registerCommand.getCard_type())
                .nameOnCard(registerCommand.getName_on_card())
                .build();
        List<CardDetailEntity> cardDetailEntityList=new ArrayList<>();
        cardDetailEntityList.add(cardDetailEntity1);

        SystemUserEntity systemUserEntity1=SystemUserEntity.builder()
                .lastName(registerCommand.getReg_last())
                .streetAddress(registerCommand.getReg_staddr())
                .cardDetailEntities(cardDetailEntityList)
                .city(registerCommand.getReg_city())
                .email(registerCommand.getReg_email())
                .firstName(registerCommand.getReg_first())
                .state(registerCommand.getReg_state())
                .zipcode(registerCommand.getReg_zip())
                .phone(registerCommand.getReg_phone())
                .username(registerCommand.getReg_user())
                .password(registerCommand.getReg_pwd())
                .role(Role.USER)
                .build();

        systemUserRepository.save(systemUserEntity1);

        return ResponseEntity.ok(RegisterResponse.builder().reg_success(true).build());

    }
}
