package com.car.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    @NonNull
    private String errorMessage;
    private LocalDateTime localDateTime = LocalDateTime.now();
}
