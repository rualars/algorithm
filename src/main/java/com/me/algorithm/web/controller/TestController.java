package com.me.algorithm.web.controller;

import com.alibaba.fastjson.JSON;
import com.me.algorithm.web.annotation.Check;
import com.me.algorithm.web.dto.TestResponseDTO;
import com.me.algorithm.web.entity.People;
import com.me.algorithm.web.repository.PeopleRepository;
import com.me.algorithm.web.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private PeopleService peopleService;

    @Check
    @GetMapping("getbyid")
    public TestResponseDTO<People> getPeopleById(Integer id) {
        if (id <= 0) {
            return new TestResponseDTO<>(0, "此ID错误", null);
        }

        return peopleService.getPeopleById(id);
    }

}
