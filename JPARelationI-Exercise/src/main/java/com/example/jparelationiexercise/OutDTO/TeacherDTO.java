package com.example.jparelationiexercise.OutDTO;

import com.example.jparelationiexercise.InputDTO.AddressDTO;
import com.example.jparelationiexercise.Model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TeacherDTO {

    private String name;

    private Integer age;

    private String email;

    private Double salary;

    private OutAddressDTO address;

//    private List<CourseDTO> courseDTOS;

}
