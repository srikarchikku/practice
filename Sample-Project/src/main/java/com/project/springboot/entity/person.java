package com.project.springboot.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class person {

    private int age;
    private String name;
}
