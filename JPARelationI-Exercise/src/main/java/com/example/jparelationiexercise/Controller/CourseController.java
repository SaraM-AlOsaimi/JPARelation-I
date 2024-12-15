package com.example.jparelationiexercise.Controller;

import com.example.jparelationiexercise.API.ApiResponse;
import com.example.jparelationiexercise.Model.Course;
import com.example.jparelationiexercise.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/school-management/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCourses(){
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));
    }

    // assign course to teacher
    @PutMapping("/assign/{teacher_id}/{course_id}")
    public ResponseEntity<?> assignCourseToTeacher(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        courseService.assignCourseToTeacher(teacher_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("Assign done Successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id,@RequestBody @Valid Course course){
        courseService.updateCourse(id,course);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));
    }


    @GetMapping("/get-teacher-name/{course_id}")
    public ResponseEntity<?> getTeacherNameForCourse(@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(courseService.getTeacherNameForCourse(course_id));
    }

    @GetMapping("/get-student-in-course/{course_id}")
    public ResponseEntity<?> getStudentInCourse(@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(courseService.getStudentInCourse(course_id));
    }

}
