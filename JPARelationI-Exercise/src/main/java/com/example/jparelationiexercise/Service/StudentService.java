package com.example.jparelationiexercise.Service;

import com.example.jparelationiexercise.API.ApiException;
import com.example.jparelationiexercise.InputDTO.InStudentDTO;
import com.example.jparelationiexercise.Model.Course;
import com.example.jparelationiexercise.Model.Student;
import com.example.jparelationiexercise.OutDTO.CourseDTO;
import com.example.jparelationiexercise.OutDTO.StudentDTO;
import com.example.jparelationiexercise.Repository.CourseRepository;
import com.example.jparelationiexercise.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<StudentDTO> getAllStudent(){
      List<Student> students = studentRepository.findAll();
      List<StudentDTO> studentDTOS = new ArrayList<>();

      for (Student s : students){
          StudentDTO studentDTO = new StudentDTO(s.getName(),s.getMajor(),s.getGPA());
          studentDTOS.add(studentDTO);
      }
      return studentDTOS;
    }


    public void addStudent(InStudentDTO inStudentDTO){
       Student student = new Student(null,inStudentDTO.getName(),inStudentDTO.getAge(),inStudentDTO.getMajor(),null,null);
       studentRepository.save(student);
    }


    public void updateStudent(Integer id , InStudentDTO inStudentDTO){
      Student student = studentRepository.findStudentById(id);
      if(student==null){
          throw new ApiException("Student not found");
      }
      student.setName(inStudentDTO.getName());
      student.setAge(inStudentDTO.getAge());
      student.setMajor(inStudentDTO.getMajor());
      studentRepository.save(student);
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if(student==null){
            throw new ApiException("Student not found");
        }
        studentRepository.delete(student);
    }

    // student roll in courses :
    public void studentRollInCourse(Integer student_id,Integer course_id){
        Student student = studentRepository.findStudentById(student_id);
        Course course = courseRepository.findCourseById(course_id);
        if(student==null || course==null){
            throw new ApiException("Can't roll");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void changeStudentMajor(Integer student_id, String major){
      Student student = studentRepository.findStudentById(student_id);
      if(student==null){
          throw new ApiException("Student not found");
      }
      student.setMajor(major);
      student.setCourses(null);
      studentRepository.save(student);
    }

}
