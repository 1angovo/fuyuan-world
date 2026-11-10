package com.example.fuyuan.service;

import com.example.fuyuan.entity.Friend;
import com.example.fuyuan.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendMapper friendMapper;

    public List<Friend> findAll() {
        return friendMapper.findAll();
    }

    public Friend findById(Long id) {
        return friendMapper.findById(id);
    }

    public void insert(Friend friend) {
        friendMapper.insert(friend);
    }

    public void update(Friend friend) {
        friendMapper.update(friend);
    }

    public void deleteById(Long id) {
        friendMapper.deleteById(id);
    }
}
