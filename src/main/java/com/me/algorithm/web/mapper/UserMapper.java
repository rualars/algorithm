package com.me.algorithm.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.me.algorithm.web.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
