package com.example.webdemo2702.beans;

import com.example.webdemo2702.dao.StudentDao;
import com.example.webdemo2702.dto.StudentDto;
import com.example.webdemo2702.entities.Student;
import com.example.webdemo2702.utils.StudentConvertor;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
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

    @Inject
    private StudentConvertor studentConvertor;

    public StudentBean() {
        studentDto = new StudentDto();
    }

    public String hello() {
        return "hello";
    }

    public List<Student> getStudents() {
        return studentDao.findAll();
    }

    public void add() {
        studentDao.add(studentConvertor.studentDtoToStudent(studentDto));
        studentDto = new StudentDto();
    }

    public void delete(int id) {
        studentDao.deleteById(id);
    }

    public String edit(int id) {
        studentDto = studentConvertor.studentToStudentDto(studentDao.findById(id));
        return "editstudent";
    }

    public String finishEdit() {
        Student student = studentConvertor.studentDtoToStudent(studentDto);
        studentDao.update(student);
        studentDto = new StudentDto();
        return "index";
    }
}
