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
public class RegisterCommand {
    private String reg_user;
    private String reg_pwd;
    private String reg_last;
    private String reg_first;
    private String reg_cnum;
    private String reg_ctype;
    private String reg_cexp;
    private String reg_staddr;
    private String reg_city;
    private String reg_state;
    private String reg_zip;
    private String reg_email;
    private String reg_phone;

    private String name_on_card;
    private String card_type;
    private String card_num;
    private String expiry_date;
}
