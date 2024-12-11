package com.example.jparelationiexercise.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "Id is empty")
    private Integer teacher_id;

    // area
   @NotEmpty(message = "area is empty")
   @Size(min = 7 , message = "area length should be more than 7 characters")
    private String area ;


    // street
    @NotEmpty(message = "street is empty")
    @Size(min = 7 , message = "street length should be more than 7 characters")
    private String street;


    // buildingNumber
    @NotNull(message = "building Number is empty")
    private Integer buildingNumber;

}
