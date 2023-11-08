package com.mobilebe.dto;

import com.mobilebe.entity.SystemUserEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllUserByAdminResponse {
    List<SystemUserEntity> systemUserEntityList;
}
