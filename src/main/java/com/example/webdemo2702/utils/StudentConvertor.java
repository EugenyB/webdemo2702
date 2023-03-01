package com.example.webdemo2702.utils;

import com.example.webdemo2702.dto.StudentDto;
import com.example.webdemo2702.entities.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class StudentConvertor {
    public Student studentDtoToStudent(StudentDto dto) {
        return Student.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .rating(dto.getRating())
                .id(dto.getId())
                .build();
    }

    public StudentDto studentToStudentDto(Student student) {
        return new StudentDto(student.getId(), student.getName(), student.getAge(), student.getRating());
    }
}
