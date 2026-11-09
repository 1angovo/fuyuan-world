package com.example.fuyuan.controller;

import com.example.fuyuan.common.Result;
import com.example.fuyuan.entity.Comment;
import com.example.fuyuan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/pending")
    public Result<List<Comment>> pending() {
        return Result.ok(commentService.findPending());
    }

    @GetMapping
    public Result<List<Comment>> list(@RequestParam(required = false) Boolean all) {
        if (Boolean.TRUE.equals(all)) {
            return Result.ok(commentService.findAll());
        }
        return Result.ok(commentService.findApproved());
    }

    @GetMapping("/page")
    public Result<Map<String, Object>> page(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return Result.ok(commentService.findPage(page, size));
    }

    @PostMapping
    public Result<Void> add(@RequestBody Comment comment) {
        commentService.insert(comment);
        return Result.ok(null);
    }

    @PutMapping("/{id}/approve")
    public Result<Void> approve(@PathVariable Long id) {
        commentService.updateStatus(id, 1);
        return Result.ok(null);
    }

    @PutMapping("/{id}/reject")
    public Result<Void> reject(@PathVariable Long id) {
        commentService.updateStatus(id, 2);
        return Result.ok(null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        commentService.deleteById(id);
        return Result.ok(null);
    }
}
