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
}
