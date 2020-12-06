package com.me.algorithm.web.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.algorithm.web.entity.User;
import com.me.algorithm.web.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository extends ServiceImpl<UserMapper, User> {

    public User getByUid(Integer uid) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", uid);
        List<User> userList = baseMapper.selectList(queryWrapper);
        if (userList == null || userList.isEmpty()) {
            return null;
        } else {
            return userList.get(0);
        }
    }

}
