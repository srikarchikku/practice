package com.project.springboot.service;

import com.project.springboot.Repository.TestRepository;
import com.project.springboot.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Async
    public CompletableFuture<Test> savetestcases(int number) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());
        Test test= new Test();
        test.setNumber(number);
        test.setName("Star-Health");
        testRepository.save(test);
        Thread.sleep(2000);
        return CompletableFuture.completedFuture(test);
    }
}
