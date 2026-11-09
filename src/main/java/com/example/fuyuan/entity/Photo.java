package com.example.fuyuan.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Photo {
    private Long id;
    private Long petId;
    private Long diaryId;
    private String imageUrl;
    private String caption;
    private String category;
    private LocalDate takenAt;
    private LocalDateTime createdAt;
}
