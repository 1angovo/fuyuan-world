package com.example.fuyuan.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class FriendPhoto {
    private Long id;
    private Long friendId;
    private String imageUrl;
    private String caption;
    private LocalDate takenAt;
    private LocalDateTime createdAt;
}
