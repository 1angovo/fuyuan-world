package com.example.fuyuan.controller;

import com.example.fuyuan.common.Result;
import com.example.fuyuan.entity.Friend;
import com.example.fuyuan.entity.FriendPhoto;
import com.example.fuyuan.mapper.FriendPhotoMapper;
import com.example.fuyuan.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friends")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @Autowired
    private FriendPhotoMapper friendPhotoMapper;

    @GetMapping
    public Result<List<Friend>> list() {
        return Result.ok(friendService.findAll());
    }

    @GetMapping("/{id}")
    public Result<Friend> detail(@PathVariable Long id) {
        return Result.ok(friendService.findById(id));
    }

    @PostMapping
    public Result<Void> add(@RequestBody Friend friend) {
        friendService.insert(friend);
        return Result.ok(null);
    }

    @PutMapping("/{id}")
    public Result<Void> update(@PathVariable Long id, @RequestBody Friend friend) {
        friend.setId(id);
        friendService.update(friend);
        return Result.ok(null);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        friendPhotoMapper.deleteByFriendId(id);
        friendService.deleteById(id);
        return Result.ok(null);
    }

    @GetMapping("/{friendId}/photos")
    public Result<List<FriendPhoto>> photos(@PathVariable Long friendId) {
        return Result.ok(friendPhotoMapper.findByFriendId(friendId));
    }

    @PostMapping("/{friendId}/photos")
    public Result<Void> addPhoto(@PathVariable Long friendId, @RequestBody FriendPhoto photo) {
        photo.setFriendId(friendId);
        friendPhotoMapper.insert(photo);
        return Result.ok(null);
    }

    @DeleteMapping("/photos/{id}")
    public Result<Void> deletePhoto(@PathVariable Long id) {
        friendPhotoMapper.deleteById(id);
        return Result.ok(null);
    }
}
