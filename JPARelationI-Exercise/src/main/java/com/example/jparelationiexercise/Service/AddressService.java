package com.example.jparelationiexercise.Service;

import com.example.jparelationiexercise.API.ApiException;
import com.example.jparelationiexercise.InputDTO.AddressDTO;
import com.example.jparelationiexercise.Model.Address;
import com.example.jparelationiexercise.Model.Teacher;
import com.example.jparelationiexercise.OutDTO.OutAddressDTO;
import com.example.jparelationiexercise.Repository.AddressRepository;
import com.example.jparelationiexercise.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<OutAddressDTO> getAllAddresses(){
      List<Address> addresses = addressRepository.findAll();
      List<OutAddressDTO> outAddressDTOS = new ArrayList<>();

      for (Address a : addresses){
          OutAddressDTO outAddressDTO = new OutAddressDTO(a.getId(),a.getArea(),a.getStreet(),a.getBuildingNumber());
          outAddressDTOS.add(outAddressDTO);
      }
      return outAddressDTOS;
    }

//    public List<Address> getAllAddresses(){
//        return addressRepository.findAll();
//    }

    public void addTeacherAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher == null){
            throw new ApiException("Teacher not found");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateTeacherAddress(AddressDTO addressDTO){
        Address oldAddress = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(oldAddress == null){
            throw new ApiException("Address not found");
        }
        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(oldAddress);
    }

}
