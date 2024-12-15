package com.example.jparelationiexercise.Controller;

import com.example.jparelationiexercise.API.ApiResponse;
import com.example.jparelationiexercise.InputDTO.AddressDTO;
import com.example.jparelationiexercise.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/school-management/teacher-address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllAddresses(){
        return ResponseEntity.status(200).body(addressService.getAllAddresses());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacherAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addTeacherAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTeacherAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.updateTeacherAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated"));
    }


}
