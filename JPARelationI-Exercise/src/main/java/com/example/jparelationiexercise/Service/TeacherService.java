package com.example.jparelationiexercise.Service;

import com.example.jparelationiexercise.API.ApiException;
import com.example.jparelationiexercise.Model.Address;
import com.example.jparelationiexercise.Model.Teacher;
import com.example.jparelationiexercise.Repository.AddressRepository;
import com.example.jparelationiexercise.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;


    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
      teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id , Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if(oldTeacher==null){
            throw new ApiException("Teacher not found");
        }
        oldTeacher.setAddress(teacher.getAddress());
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setEmail(teacher.getEmail());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("Teacher not found");
        }
        Address address = addressRepository.findAddressById(id);
        if(address==null){
            throw new ApiException("address not found");
        }
        teacher.setAddress(null);
        addressRepository.delete(address);
        teacherRepository.delete(teacher);
    }


    // Create endpoint that takes teacher id and return All teacher details
    public Teacher getTeacherDetails(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
            if(teacher==null){
                throw new ApiException("Teacher not found");
        }
       return teacher;
    }

}
