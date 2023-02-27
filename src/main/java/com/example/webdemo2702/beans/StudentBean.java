package com.example.webdemo2702.beans;

import com.example.webdemo2702.dao.StudentDao;
import com.example.webdemo2702.dto.StudentDto;
import com.example.webdemo2702.entities.Student;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class StudentBean implements Serializable {

    @Getter @Setter
    private StudentDto studentDto;

    @EJB
    private StudentDao studentDao;

    public StudentBean() {
        studentDto = new StudentDto();
    }

    public String hello() {
        return "hello";
    }

    public List<Student> getStudents() {
        return studentDao.findAll();
    }
}
