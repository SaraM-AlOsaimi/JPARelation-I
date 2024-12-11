package com.example.jparelationiexercise.Controller;

import com.example.jparelationiexercise.API.ApiResponse;
import com.example.jparelationiexercise.Model.Teacher;
import com.example.jparelationiexercise.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/school-management/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody @Valid Teacher teacher){
       teacherService.addTeacher(teacher);
       return ResponseEntity.status(200).body(new ApiResponse("Teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id , @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id){
       teacherService.deleteTeacher(id);
       return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));
    }


    // Create endpoint that takes teacher id and return All teacher details
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTeacherDetails(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }
}
