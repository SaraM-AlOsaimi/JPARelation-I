package com.example.jparelationiexercise.Service;

import com.example.jparelationiexercise.API.ApiException;
import com.example.jparelationiexercise.Model.Course;
import com.example.jparelationiexercise.Model.Student;
import com.example.jparelationiexercise.Model.Teacher;
import com.example.jparelationiexercise.OutDTO.CourseDTO;
import com.example.jparelationiexercise.OutDTO.StudentDTO;
import com.example.jparelationiexercise.Repository.CourseRepository;
import com.example.jparelationiexercise.Repository.StudentRepository;
import com.example.jparelationiexercise.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public List<CourseDTO> getAllCourses(){
       List<Course> courses = courseRepository.findAll();
       List<CourseDTO> courseDTOS = new ArrayList<>();

       for(Course c : courses){
         CourseDTO  courseDTO = new CourseDTO(c.getName());
         courseDTOS.add(courseDTO);
       }
       return courseDTOS;
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    // assign course to a teacher
    public void assignCourseToTeacher(Integer teacher_id,Integer course_id){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);
        if(teacher==null || course==null){
            throw new ApiException("Can't assign");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course){
        Course oldCourse = courseRepository.findCourseById(id);
        if(oldCourse==null){
            throw new ApiException("Course not found");
        }
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id){
      Course course = courseRepository.findCourseById(id);
      if(course==null){
          throw new ApiException("Course not found");
      }
//      course.setTeacher(null);
        courseRepository.delete(course);
    }


    public String getTeacherNameForCourse(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        if(course==null){
            throw new ApiException("Course not found");
        }
        Teacher teacher = course.getTeacher();
        return "Teacher name for course with id " +  course_id + " is: " + teacher.getName();
    }

    // take course id and return the list of students
    public List<StudentDTO> getStudentInCourse(Integer course_id){
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student s : students){
            StudentDTO studentDTO = new StudentDTO(s.getName(),s.getMajor(),s.getGPA());
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

}
