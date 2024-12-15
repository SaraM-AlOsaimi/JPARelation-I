package com.example.jparelationiexercise.Controller;

import com.example.jparelationiexercise.API.ApiResponse;
import com.example.jparelationiexercise.InputDTO.InStudentDTO;
import com.example.jparelationiexercise.Model.Student;
import com.example.jparelationiexercise.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/school-management/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllStudents(){
        return ResponseEntity.status(200).body(studentService.getAllStudent());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid InStudentDTO inStudentDTO){
      studentService.addStudent(inStudentDTO);
      return ResponseEntity.status(200).body(new ApiResponse("Student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id,@RequestBody @Valid InStudentDTO inStudentDTO){
        studentService.updateStudent(id,inStudentDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Student updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));
    }

    // assign students to course
    @PutMapping("/roll-in-course/{student_id}/{course_id}")
    public ResponseEntity<?> studentRollInCourse(@PathVariable Integer student_id,@PathVariable Integer course_id){
        studentService.studentRollInCourse(student_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("Roll successfully"));
    }

    // student change major
    @PutMapping("/change-major/{student_id}/{major}")
    public ResponseEntity<?> changeStudentMajor(@PathVariable Integer student_id,@PathVariable String major){
      studentService.changeStudentMajor(student_id,major);
      return ResponseEntity.status(200).body(new ApiResponse("Major updated"));
    }


}
