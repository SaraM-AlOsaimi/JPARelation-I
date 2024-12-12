package com.example.jparelationiexercise.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "course name is required")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;
}
