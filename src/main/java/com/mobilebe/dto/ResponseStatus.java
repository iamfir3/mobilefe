package com.mobilebe.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStatus {
    private String status;
}
