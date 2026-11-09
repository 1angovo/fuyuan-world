package com.example.fuyuan.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Diary {
    private Long id;
    private Long petId;
    private String title;
    private String content;
    private String diaryType;
    private LocalDate eventDate;
    private LocalDateTime createdAt;
}
