package com.example.webdemo2702.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private int id;
    private String name;
    private int age;
    private double rating;
}
