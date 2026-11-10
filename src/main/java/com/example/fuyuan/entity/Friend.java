package com.example.fuyuan.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Friend {
    private Long id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private LocalDate birthday;
    private String personality;
    private String description;
    private String avatarUrl;
    private LocalDateTime createdAt;
}
