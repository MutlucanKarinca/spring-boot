package com.mutlucankarinca.springbootcamp.dto;

import com.mutlucankarinca.springbootcamp.enums.EnumStatus;

import java.time.LocalDate;

public record CustomerSaveRequest(String name,
                                  String surname,
                                  String username,
                                  String password,
                                  String email,
                                  LocalDate birthDate,
                                  EnumStatus status) {


}
