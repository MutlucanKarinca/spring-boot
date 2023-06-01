package com.mutlucankarinca.springbootcamp.general;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GenericErrorMessages {

    private LocalDateTime errorDate;
    private String message;
    private String detail;
}
