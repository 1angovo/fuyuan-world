package com.example.fuyuan.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private String nickname;
    private String content;
    private Integer status;
    private LocalDateTime createdAt;
}
