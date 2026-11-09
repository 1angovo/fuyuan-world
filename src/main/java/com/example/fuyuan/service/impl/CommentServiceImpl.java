package com.example.fuyuan.service.impl;

import com.example.fuyuan.entity.Comment;
import com.example.fuyuan.mapper.CommentMapper;
import com.example.fuyuan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findPending() {
        return commentMapper.findPending();
    }

    @Override
    public List<Comment> findApproved() {
        return commentMapper.findApproved();
    }

    @Override
    public List<Comment> findAll() {
        return commentMapper.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentMapper.findById(id);
    }

    @Override
    public Map<String, Object> findPage(int page, int size) {
        int offset = (page - 1) * size;
        List<Comment> records = commentMapper.findPage(offset, size);
        int total = commentMapper.count();
        Map<String, Object> result = new HashMap<>();
        result.put("records", records);
        result.put("total", total);
        result.put("page", page);
        result.put("size", size);
        return result;
    }

    @Override
    public void insert(Comment comment) {
        if (comment.getStatus() == null) {
            comment.setStatus(0);
        }
        commentMapper.insert(comment);
    }

    @Override
    public void updateStatus(Long id, int status) {
        commentMapper.updateStatus(id, status);
    }

    @Override
    public void deleteById(Long id) {
        commentMapper.deleteById(id);
    }
}
