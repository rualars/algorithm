package com.me.algorithm.web.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.algorithm.web.entity.People;
import com.me.algorithm.web.mapper.PeopleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleRepository extends ServiceImpl<PeopleMapper, People> {

    public People getById(Integer id) {
        QueryWrapper<People> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        List<People> peopleList = baseMapper.selectList(queryWrapper);
        if (peopleList == null || peopleList.isEmpty()) {
            return null;
        } else {
            return peopleList.get(0);
        }
    }

}
