package com.project.springboot.controller;

import com.project.springboot.entity.Test;
import com.project.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping("/{number}")
    public Void create (@PathVariable("number") int number) throws InterruptedException {
        List<CompletableFuture<Test>> listoftask = new ArrayList<>();

        try
        {
            for(int i=0;i<13;i++)
            {
                CompletableFuture<Test> test= testService.savetestcases(number);

                listoftask.add(test);
            }
            CompletableFuture.completedFuture(listoftask);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }
}
