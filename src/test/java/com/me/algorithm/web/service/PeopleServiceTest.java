package com.me.algorithm.web.service;

import com.alibaba.fastjson.JSON;
import com.me.algorithm.AlgorithmApplication;
import com.me.algorithm.web.dto.TestResponseDTO;
import com.me.algorithm.web.entity.People;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlgorithmApplication.class)
class PeopleServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(PeopleServiceTest.class);

    @Autowired
    private PeopleService peopleService;

    @Test
    void getPeopleById() {
        TestResponseDTO<People> dto = peopleService.getPeopleById(1);
        logger.info(JSON.toJSONString(dto));
    }
}