package com.me.algorithm.web.service;

import com.me.algorithm.web.dto.TestResponseDTO;
import com.me.algorithm.web.entity.People;
import com.me.algorithm.web.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public TestResponseDTO<People> getPeopleById(Integer id) {

        People people = peopleRepository.getById(id);

        if (people == null) {
            return new TestResponseDTO<>(0, "没有找到此ID的人员信息", null);
        }
        return new TestResponseDTO<>(1, "操作成功", people);
    }

}
