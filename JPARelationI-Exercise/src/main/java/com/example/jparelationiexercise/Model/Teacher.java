package com.example.jparelationiexercise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.util.Set;

@Data
@Check(constraints = "age >= 18")
@Check(constraints = "salary > 0")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // name
    @NotEmpty(message = "Your name is empty")
    @Size(min = 3 , max = 20 , message = "name length should be between 3 and 20 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    // age
    @NotNull(message = "age is null")
    @Min(value = 18 , message = "your age should be 18 or above")
    @Column(columnDefinition = "int not null")
    private Integer age;


    // email
    @NotBlank(message = "email can't be blank")
    @Email(message = "enter a valid email format")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    // salary
    @NotNull(message = "salary is empty")
    @Positive(message = "Salary should be a above zero")
    @Column(columnDefinition = "double not null")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "teacher")
    private Set<Course> courses;
}
