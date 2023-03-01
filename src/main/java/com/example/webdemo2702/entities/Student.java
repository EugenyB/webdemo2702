package com.example.webdemo2702.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "student")
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "select s from Student s")
})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "age")
    private Integer age;

}