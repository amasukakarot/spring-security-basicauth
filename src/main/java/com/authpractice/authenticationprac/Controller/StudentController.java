package com.authpractice.authenticationprac.Controller;

import com.authpractice.authenticationprac.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENT_LIST = Arrays.asList(
            new Student(1, "James Smith"),
            new Student(2,"Anna Johnson"),
            new Student(3,"Muhammad Khan")
    );

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENT_LIST.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " not found"));

    }
}
