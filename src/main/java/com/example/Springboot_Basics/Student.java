package com.example.Springboot_Basics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Student {
    public int age;
    public String name;
}
