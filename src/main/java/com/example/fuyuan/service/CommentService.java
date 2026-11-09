package com.example.fuyuan.service;

import com.example.fuyuan.entity.Comment;
import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Comment> findPending();
    List<Comment> findApproved();
    List<Comment> findAll();
    Comment findById(Long id);
    Map<String, Object> findPage(int page, int size);
    void insert(Comment comment);
    void updateStatus(Long id, int status);
    void deleteById(Long id);
}
