package com.example.jparelationiexercise.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name is required")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "age is null")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "major is empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String major;

    @Column(columnDefinition = "double")
    private Double GPA;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
