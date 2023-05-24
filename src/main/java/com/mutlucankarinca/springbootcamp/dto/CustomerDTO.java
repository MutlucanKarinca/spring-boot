package com.mutlucankarinca.springbootcamp.dto;

import com.mutlucankarinca.springbootcamp.enums.EnumStatus;

import java.time.LocalDate;

public record CustomerDTO(Long id,
                          String name,
                          String surname,
                          String username,
                          String email,
                          LocalDate birthDate,
                          EnumStatus status) {
}
