package com.example.webdemo2702.dao;

import com.example.webdemo2702.entities.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class StudentDao {
    @PersistenceContext
    private EntityManager em;

    public List<Student> findAll() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    public void add(Student student) {
        em.persist(student);
    }

    public void deleteById(int id) {
        Student student = findById(id);
        if (student != null) {
            em.remove(student);
        }
    }

    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    public void update(Student editedStudent) {
        Student student = findById(editedStudent.getId());
        student.setName(editedStudent.getName());
        student.setAge(editedStudent.getAge());
        student.setRating(editedStudent.getRating());
        em.merge(student);
    }
}
