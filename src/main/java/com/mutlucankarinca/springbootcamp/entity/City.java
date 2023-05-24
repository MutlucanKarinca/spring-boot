package com.mutlucankarinca.springbootcamp.entity;

import com.mutlucankarinca.springbootcamp.general.BaseEntity;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class City extends BaseEntity {
    @Id
    private Long id;
}
