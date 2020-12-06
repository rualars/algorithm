package com.me.algorithm.web.repository;

import com.me.algorithm.AlgorithmApplication;
import com.me.algorithm.web.entity.People;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@EnableAutoConfiguration
@SpringBootTest(classes = AlgorithmApplication.class)
@RunWith(SpringRunner.class)
public class PeopleRepositoryTest {

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void getById() {
        People people = peopleRepository.getById(1);
        return;
    }

}
