package com.example.fuyuan.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Pet {
    private Long id;
    private String name;
    private String breed;
    private String gender;
    private LocalDate birthday;
    private LocalDate arrivalDate;
    private String personality;
    private String hobbies;
    private String description;
    private String avatarUrl;
    private LocalDateTime createdAt;
}
