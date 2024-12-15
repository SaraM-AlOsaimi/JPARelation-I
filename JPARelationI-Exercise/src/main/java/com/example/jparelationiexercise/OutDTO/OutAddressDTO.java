package com.example.jparelationiexercise.OutDTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutAddressDTO {

    private Integer teacher_id;

    private String area ;

    private String street;

    private Integer buildingNumber;

}
